<%
    session.invalidate();
    response.sendRedirect(response.encodeRedirectUrl(request.getContextPath()));
%>