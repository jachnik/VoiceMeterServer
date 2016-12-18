package pl.put.poznan;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Path("event")
public class EventAPI {
	@Autowired
	private ApplicationContext context;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void handlePost(@RequestBody Event event){
		System.out.println(event.getDeviceIdentifier() + ":" + event.getVoicePower());
		MessageChannel toKafka = context.getBean("toKafka", MessageChannel.class);
		toKafka.send(new GenericMessage<>(String.valueOf(event.getVoicePower())));
	}
}
