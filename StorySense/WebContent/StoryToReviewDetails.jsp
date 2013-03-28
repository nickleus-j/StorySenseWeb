<%@page import="dao.*"%>
<%@page import="entity.*"%>
<% 

int sID=Integer.parseInt(request.getParameter("q"));

DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
Acomplishment acom;

acom=myAcomDAO.getStory(sID);
out.write("Title:");
%>

<h2><% out.write(acom.getName()); %></h2>
