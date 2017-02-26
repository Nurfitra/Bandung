package net.bandung.handler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bandung.bean.PostBean;
import net.bandung.bean.UserBean;
import net.bandung.dao.PostDao;

public class Index extends HttpServlet {    
    private static String Beranda = "/beranda.jsp";
    private static String Destinasi = "/destinasi.jsp";
    private static String Destinasi_detail = "/destinasi_detail.jsp";
    private static String Event = "/event.jsp";
    private static String Event_detail = "/event_detail.jsp";
    private static String Kontak = "/kontak.jsp";
    private static String Tentang = "/tentang.jsp";
    private PostDao dao;

    public Index() {
        super();
        dao = new PostDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String action = request.getParameter("page");
        String sort = request.getParameter("sort");
        String id = request.getParameter("destinasiId");
        //String Id = request.getParameter("Id");
		if (action.equalsIgnoreCase("tentang")) {
			redirect = Tentang;
		} else if (action.equalsIgnoreCase("destinasi")) {
			if (sort.equalsIgnoreCase("semua")) {
				redirect = Destinasi;
			}else if (sort.equalsIgnoreCase("alam")) {
				redirect = Destinasi;
			}else if (sort.equalsIgnoreCase("museum")) {
				redirect = Destinasi;
			}else if (sort.equalsIgnoreCase("taman")) {
				redirect = Destinasi;
			}else if (sort.equalsIgnoreCase("kuliner")) {
				redirect = Destinasi;
			}else if (sort.equalsIgnoreCase("detail")) {
				redirect = Destinasi_detail;
			}
			
		} else if (action.equalsIgnoreCase("detail_destinasi")) {
			System.out.println("Detail Destinasi");
		} else if (action.equalsIgnoreCase("event")) {
			redirect = Event;
			if(sort != null){
				if (sort.equalsIgnoreCase("detail")) {
					redirect = Event_detail;
				}
			}
		} else if (action.equalsIgnoreCase("kontak")) {
			redirect = Kontak;
		} else {
			redirect = Beranda;
            request.setAttribute("post", dao.getLastPosts());
		}

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}