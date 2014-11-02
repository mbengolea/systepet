package utilidades;

import java.security.Security;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dominio.AplicacionAgendada;
import dominio.ConfiguracionEnvioRecordatorios;
import dominio.Recordatorio;

public class EnviadorDeRecordatorios {

	public static void main(String[] args) {
		new EnviadorDeRecordatorios().enviarRecordatorios();
	}

	public void enviarRecordatorios() {
		ConfiguracionEnvioRecordatorios config = BaseDeDatos.getBaseDeDatos()
				.buscarConfiguracionEnvioDeRecordatorios();
		final String username = config.getUsuario();
		final String password = config.getPassword();
		String asunto = config.getAsunto();
		String plantilla = config.getPlantilla();

		Session session = getEmailSession(username, password);
		List<Recordatorio> recordatorios = BaseDeDatos.getBaseDeDatos()
				.buscarAplicacionesAgendadas();

		for (Recordatorio record : recordatorios) {
			String destino = record.getEmail();

			final MimeMessage msg = new MimeMessage(session);

			try {
				msg.setFrom(new InternetAddress(config.getEmailOrigen()));
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(destino, false));
				msg.setSubject(asunto);
				String contenido = record.generarTextoEmail(plantilla);
				msg.setText(contenido, "utf-8");
				msg.setSentDate(new Date());
				Transport.send(msg);
				this.recordatorioEnviado(record);
			} catch (Exception e) {
				System.out.println("No se ha podido enviar el recordatorio");
				e.printStackTrace();
			}
		}
	}

	private void recordatorioEnviado(Recordatorio record) {
		AplicacionAgendada aplicacion = record.getAplicacion();
		aplicacion.setRecordatorioEnviado(true);
		BaseDeDatos.getBaseDeDatos().actualizarAplicacionAgendada(aplicacion);
	}

	private Session getEmailSession(final String username, final String password) {
//		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtps.quitwait", "false");
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		return session;
	}
}
