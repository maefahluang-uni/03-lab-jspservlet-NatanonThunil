package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));

        // TODO: calculate bmi

        double bmi = weight / (height * height);

        // TODO: determine the built from BMI
        String bodyType;
        if (bmi < 18.5) {
            bodyType = "underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            bodyType = "normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            bodyType = "overweight";
        } else if (bmi >=30 && bmi < 34.9) {
            bodyType = "obese";
        }else{
            bodyType = "extremely obese";
        }

        // TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("build", bodyType);

        // TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);

    }

}
