package ar.edu.dueloWeb.controller;

import dueloDeLeyendas.dominio.applicationModel.EstadisticasRep;
import dueloDeLeyendas.dominio.applicationModel.PersonajeRep;
import dueloDeLeyendas.dominio.applicationModel.RepoWeb;
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class DueloController extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private final RepoWeb repo = new RepoWeb(new Jugador("Marcos", new SistemaDeDuelos(new RealizadorDuelo())));
  
  public static void main(final String[] args) {
    XTRest.start(DueloController.class, 9000);
  }
  
  @Get("/posiciones")
  public Result posiciones(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final ArrayList<String> posiciones = CollectionLiterals.<String>newArrayList();
      final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
        public void apply(final ArrayList<String> it) {
          it.add("TOP");
          it.add("MID");
          it.add("BOT");
          it.add("JUNGLE");
        }
      };
      ObjectExtensions.<ArrayList<String>>operator_doubleArrow(posiciones, _function);
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(posiciones);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/personajes")
  public Result personajes(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final ArrayList<PersonajeRep> pers = this.repo.personajes();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(pers);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/personajesNombres")
  public Result personajesNombres(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      ArrayList<PersonajeRep> _personajes = this.repo.personajes();
      final Function1<PersonajeRep, String> _function = new Function1<PersonajeRep, String>() {
        public String apply(final PersonajeRep it) {
          return it.getNombre();
        }
      };
      final List<String> pers = ListExtensions.<PersonajeRep, String>map(_personajes, _function);
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(pers);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/personajesNombres/:personaje")
  public Result datosDePersonaje(final String personaje, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      ArrayList<PersonajeRep> _personajes = this.repo.personajes();
      final Function1<PersonajeRep, Boolean> _function = new Function1<PersonajeRep, Boolean>() {
        public Boolean apply(final PersonajeRep it) {
          String _nombre = it.getNombre();
          return Boolean.valueOf(_nombre.equals(personaje));
        }
      };
      final Iterable<PersonajeRep> pers = IterableExtensions.<PersonajeRep>filter(_personajes, _function);
      final PersonajeRep pri = ((PersonajeRep[])Conversions.unwrapArray(pers, PersonajeRep.class))[0];
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(pri);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/personajesNombres/:personaje/estadisticas")
  public Result estadisticasDePersonaje(final String personaje, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      ArrayList<PersonajeRep> _personajes = this.repo.personajes();
      final Function1<PersonajeRep, Boolean> _function = new Function1<PersonajeRep, Boolean>() {
        public Boolean apply(final PersonajeRep it) {
          String _nombre = it.getNombre();
          return Boolean.valueOf(_nombre.equals(personaje));
        }
      };
      final Iterable<PersonajeRep> pers = IterableExtensions.<PersonajeRep>filter(_personajes, _function);
      PersonajeRep _get = ((PersonajeRep[])Conversions.unwrapArray(pers, PersonajeRep.class))[0];
      final EstadisticasRep pri = _get.getStat();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(pri);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/resultadoDuelo/:peers/:pos")
  public Result resultadoDuelo(final String peers, final String pos, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final RealizadorDuelo realizador = new RealizadorDuelo();
      final SistemaDeDuelos sistema = new SistemaDeDuelos(realizador);
      final Jugador marcos = new Jugador("marcos", sistema);
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson("");
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/posiciones").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = posiciones(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/personajes").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = personajes(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/personajesNombres").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = personajesNombres(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/personajesNombres/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String personaje = matcher.group(1);
    		
    		
    	    Result result = datosDePersonaje(personaje, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/personajesNombres/(\\w+)/estadisticas").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String personaje = matcher.group(1);
    		
    		
    	    Result result = estadisticasDePersonaje(personaje, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/resultadoDuelo/(\\w+)/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String peers = matcher.group(1);
    		String pos = matcher.group(2);
    		
    		
    	    Result result = resultadoDuelo(peers, pos, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/posiciones</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/personajes</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/personajesNombres</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/personajesNombres/:personaje</td>"
    	+ "				<td>personaje</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/personajesNombres/:personaje/estadisticas</td>"
    	+ "				<td>personaje</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/resultadoDuelo/:peers/:pos</td>"
    	+ "				<td>peers, pos</td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
