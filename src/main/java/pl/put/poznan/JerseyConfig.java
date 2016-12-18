package pl.put.poznan;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(ObjectMapper objectMapper){
		packages("pl.put.poznan");
		register(new ObjectMapperContextResolver(objectMapper));
	}
	
	public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

		private final ObjectMapper mapper;
		
		public ObjectMapperContextResolver(ObjectMapper objectMapper) {
			this.mapper = objectMapper;
		}
		
		@Override
		public ObjectMapper getContext(Class<?> arg0) {
			return mapper;
		}
		
	}
}
