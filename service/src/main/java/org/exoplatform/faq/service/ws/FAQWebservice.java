package org.exoplatform.faq.service.ws;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.faq.service.FAQService;
import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * Handles REST request to process FAQ.
 * 
 * @anchor FAQWebservice
 */
@Path("ks/faq")
public class FAQWebservice implements ResourceContainer {

  protected final static String JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON;

  final public static String    APP_TYPE          = "faq".intern();

  public FAQWebservice() {
  }

  /**
   * Views RSS feeds by the provided source.
   * 
   * @param resourceid The RSS source Id to view.
   * 
   * @anchor FAQWebservice.viewrss
   * 
   * @return The response is xml data which contains the returned RSS.
   * 
   * @throws Exception
   * 
   * @LevelAPI Platform
   */
  @GET
  @Path("rss/{resourceid}")
  @Produces(MediaType.APPLICATION_XML)
  public Response viewrss(@PathParam("resourceid") String resourceid) throws Exception {
    CacheControl cacheControl = new CacheControl();
    cacheControl.setNoCache(true);
    cacheControl.setNoStore(true);
    try {
      FAQService faqService = (FAQService) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(FAQService.class);
      InputStream is = faqService.createAnswerRSS(resourceid);
      return Response.ok(is, MediaType.APPLICATION_XML).cacheControl(cacheControl).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
  }

}
