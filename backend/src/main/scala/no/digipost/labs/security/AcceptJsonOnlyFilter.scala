package no.digipost.labs.security

import org.scalatra._

trait AcceptJsonOnlyFilter { self: ScalatraServlet with ApiFormats =>

  /**
   * Only accepting json body from clients
   */
  before(List("POST", "PUT", "PATCH").contains(request.getMethod)) {
    if (format(request, response) != "json") halt(UnsupportedMediaType())
  }
}
