package net.bandung.handler;

import java.io.*;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import net.bandung.bean.UserBean;
import net.bandung.dao.UserDao;
import net.bandung.bean.PostBean;
import net.bandung.dao.PostDao;
import net.bandung.bean.EventBean;
import net.bandung.dao.EventDao;
import net.bandung.dbconnection.ConnectionProvider;
public class Admin extends HttpServlet {    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6764617319733244884L;
	private static String Adduser = "/admin/addusers.jsp";
    private static String EditUser = "/admin/editusers.jsp";
    private static String UserList = "/admin/userlist.jsp";
	private static String AddDestinasi = "/admin/adddestinasi.jsp";
    private static String EditDestinasi = "/admin/editdestinasi.jsp";
    private static String DestinasiList = "/admin/destinasilist.jsp";
	private static String AddEvent = "/admin/addevent.jsp";
    private static String EditEvent= "/admin/editevent.jsp";
    private static String EventList = "/admin/eventlist.jsp";
    private static String Login = "/admin/login.jsp";
    private static String Dashboard = "/admin/dashboard.jsp";
    private UserDao Userdao;
    private PostDao Postdao;
    private EventDao Eventdao;
    private Connection conn;

    public Admin() {
        super();
        Userdao = new UserDao();
        Postdao = new PostDao();
        Eventdao = new EventDao();
        conn = ConnectionProvider.getConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String uId = request.getParameter("userId");
        String action = request.getParameter("action");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("username")=="" || session.getAttribute("username")==null)
        {
        	if(action != null){
        		
	       	 	if (action.equalsIgnoreCase("login")){
		        	 
		        	String email = request.getParameter("email");
		        	String password = request.getParameter("password");
		        	 	            
		           try {
		          	String sql = "SELECT * FROM users WHERE email=? AND password=?";
		              PreparedStatement ps = conn.prepareStatement(sql);
		  			  ps.setString(1, email);
		              ps.setString(2, password);
		              ResultSet rs = ps.executeQuery();
	
		 	            if (rs.next()) {
		 	              	 session.setAttribute("username", rs.getString("username"));
		 	              	 redirect = Dashboard;
		 	            }else{
		 	            	 System.out.println("Data tidak ditemukan");
		 	            	 redirect = Login;
		 	            }
		 	            rs.close();
		 	            ps.close(); 
		 	        } catch (SQLException e) {
		 	            e.printStackTrace();
		 	        }
		         }
	       	 	
        	} else {
	        	 redirect = Login;
	        }
        } else {
        	if(action != null){
	        	if(action.equalsIgnoreCase("adduser"))
	 	        {
	 	        	UserBean user = new UserBean();
	 	            user.setUname(request.getParameter("username"));
	 	            user.setEmail(request.getParameter("email"));
	 	            user.setPass(request.getParameter("password"));
	 	            Userdao.addUser(user);
	 	        	redirect = UserList;
	 	            request.setAttribute("users", Userdao.getAllUsers());    
	 	           	System.out.println("Record Added Successfully");
	 	        } else if (action.equalsIgnoreCase("deleteuser")){
	 	            String userId = request.getParameter("userId");
	 	            int uid = Integer.parseInt(userId);
	 	            Userdao.removeUser(uid);
	 	            redirect = UserList;
	 	            request.setAttribute("users", Userdao.getAllUsers());
	 	            System.out.println("Record Deleted Successfully");
	 	        } else if (action.equalsIgnoreCase("editform")){        	
	 	        	redirect = EditUser;            
	 	        } else if (action.equalsIgnoreCase("edituser")){
	 	        	String userId = request.getParameter("userId");
	 	            int uid = Integer.parseInt(userId);
	 	            UserBean user = new UserBean();
	 	        	user.setId(uid);
	 	            user.setUname(request.getParameter("username"));
	 	            user.setEmail(request.getParameter("email"));
	 	            user.setPass(request.getParameter("password"));
	 	            Userdao.editUser(user);
	 	            redirect = UserList;
	 	            System.out.println("Record updated Successfully");
	 	        } else if (action.equalsIgnoreCase("listUser")){
	 	            redirect = UserList;
	 	            request.setAttribute("users", Userdao.getAllUsers());
	 	        	 //System.out.println("test");
	 	        } else if (action.equalsIgnoreCase("logout")){
	 	        	session.removeAttribute("username");
	 	        	session.invalidate();
	 	        	redirect = Login;
	 	        /* Destinasi */
	  	        } else if(action.equalsIgnoreCase("addDestinasi")) {
	  	        	PostBean post = new PostBean();
	  	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	  	        	String date = sdf.format(new Date());
	  	        	String author = (String) session.getAttribute("username");
	  	        	
	  	        	post.setJudul(request.getParameter("judul"));
	  	        	post.setIsi(request.getParameter("deskripsi"));
	  	        	//post.setGambar(request.getParameter("gambar"));
	  	        	post.setKategori(request.getParameter("kategori"));
	  	        	post.setAuthor(author);
	  	        	post.setDate(date.toString());

	  	        	System.out.println(request.getParameter("judul"));
	  	        	System.out.println(request.getParameter("deskripsi"));
	  	        	System.out.println(request.getParameter("kategori"));
	  	        	System.out.println(author);
	  	        	System.out.println(date.toString());
	  	        	
	 	            Postdao.addPost(post);
	 	        	redirect = DestinasiList;
	 	            request.setAttribute("destinasi", Postdao.getAllPosts());    
	 	           	System.out.println("Record Added Successfully");
	 	        } else if (action.equalsIgnoreCase("deleteDestinasi")){
	 	            String postId = request.getParameter("postId");
	 	            int pid = Integer.parseInt(postId);
	 	            Postdao.removePost(pid);
	 	            redirect = DestinasiList;
	 	            request.setAttribute("destinasi", Postdao.getAllPosts());
	 	            System.out.println("Record Deleted Successfully");
	 	        } else if (action.equalsIgnoreCase("addformDestinasi")){        	
	 	        	redirect = AddDestinasi;            
	 	        } else if (action.equalsIgnoreCase("editformDestinasi")){        	
	 	        	redirect = EditDestinasi;            
	 	        } else if (action.equalsIgnoreCase("editDestinasi")){
	 	        	String postId = request.getParameter("postId");
	 	            int pid = Integer.parseInt(postId);
	 	            PostBean post = new PostBean();
	 	            post.setPid(pid);
	  	        	post.setJudul(request.getParameter("judul"));
	  	        	post.setIsi(request.getParameter("deskripsi"));
	  	        	//post.setGambar(request.getParameter("gambar"));
	  	        	post.setKategori(request.getParameter("kategori"));
	 	            Postdao.editPost(post);
	 	            redirect = DestinasiList;
	 	            System.out.println("Record updated Successfully");
	 	        } else if (action.equalsIgnoreCase("listDestinasi")){
	 	            redirect = DestinasiList;
	 	            request.setAttribute("destinasi", Postdao.getAllPosts());
	 	        	 //System.out.println("test");
		 	    /* Event */
	 	        } else if(action.equalsIgnoreCase("addEvent")) {
	 	        	EventBean event = new EventBean();
	 	        	event.setEvent(request.getParameter("event"));
	 	        	event.setIsi(request.getParameter("deskripsi"));
	 	        	//event.setGambar(request.getParameter("gambar"));
	 	        	Eventdao.addEvent(event);
	 	        	redirect = EventList;
	 	            request.setAttribute("events", Eventdao.getAllEvents());    
	 	           	System.out.println("Record Added Successfully");
	 	        } else if (action.equalsIgnoreCase("deleteEvent")){
	 	            String eventId = request.getParameter("eventId");
	 	            int eid = Integer.parseInt(eventId);
	 	            Eventdao.removeEvent(eid);
	 	            redirect = EventList;
	 	            request.setAttribute("events", Eventdao.getAllEvents());
	 	            System.out.println("Record Deleted Successfully");
	 	        } else if (action.equalsIgnoreCase("editformEvent")){        	
	 	        	redirect = EditEvent;            
	 	        } else if (action.equalsIgnoreCase("addformEvent")){        	
	 	        	redirect = AddEvent;            
	 	        } else if (action.equalsIgnoreCase("editEvent")){
	 	        	String eventId = request.getParameter("eventId");
	 	            int eid = Integer.parseInt(eventId);
	 	            EventBean event = new EventBean();
	 	            event.setEid(eid);
	 	        	event.setEvent(request.getParameter("event"));
	 	        	event.setIsi(request.getParameter("deskripsi"));
	 	        	//event.setGambar(request.getParameter("gambar"));
	 	            Eventdao.editEvent(event);
	 	            redirect = EventList;
	 	            System.out.println("Record updated Successfully");
	 	        } else if (action.equalsIgnoreCase("listEvent")){
	 	            redirect = EventList;
	 	            request.setAttribute("events", Eventdao.getAllEvents());
	 	        	 //System.out.println("test");
	 	        } else if (action.equalsIgnoreCase("logout")){
	 	        	session.removeAttribute("username");
	 	        	session.invalidate();
	 	        	redirect = Login;
	  	        }else{
	  	        	redirect = Adduser;
	  	        }
        	 } else {
 	            redirect = Dashboard;
        	 }
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}