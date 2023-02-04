package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/addorder"})
public class AddOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        FoodDAO food = new FoodDAO();
        List<Item> t = new ArrayList<>();
        int foodid, quantity, index;
        double sum = 0;
        int count = Integer.parseInt(request.getParameter("countt"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        AccountDAO b = new AccountDAO();
        int accid = a.getId();
        String foodName;
        Icon icon = (Icon) session.getAttribute("icon");

        for (int i = 0; i < count; i++) {
            foodid = Integer.parseInt(request.getParameter("foodidd" + i));
            quantity = Integer.parseInt(request.getParameter("inputquantity" + i));
            sum = sum + food.getPriceByFoodId(foodid) * quantity;
            t.add(new Item(accid, foodid, quantity));
        }

        if (sum > icon.getCurrentMoney()) {
            List<Food> getFoodAddToCart = food.getFoodAddToCart(accid);
            request.setAttribute("icon", icon);
            request.setAttribute("listadd", getFoodAddToCart);
            request.setAttribute("message", "YOU DON'T HAVE ENOUGH MONEY （◞‸◟）");
            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);

        } else {
            food.createBill(accid);
            index = food.getBillIndex(accid);
            for (Item item : t) {
                if (item.getQuantity() != 0) {
                    if (item.getQuantity() > food.getQuantityByFoodId(item.getFoodid())) {
                        foodName = food.getNameByFoodId(item.getFoodid());
                        List<Food> getFoodAddToCart = food.getFoodAddToCart(accid);
                        request.setAttribute("icon", icon);
                        request.setAttribute("listadd", getFoodAddToCart);
                        request.setAttribute("message", "YOU CAN'T TOO MUCH STUFF OF  " + foodName + "（◞‸◟）");
                        request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
                        break;
                    } else {
                        food.AddToOrder(item.getAccid(), item.getFoodid(), item.getQuantity(), index);
                        food.DeleteAddToCartToMakeOrder(item.getAccid(), item.getFoodid());
                        food.comsumeQuantity(item.getFoodid(), item.getQuantity());
                    }
                }
            }
        b.MinusPayment(sum, accid);
        response.sendRedirect("shoppingcart");
        }

    }

}
