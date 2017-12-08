/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author Stanislav
 */
public class FormattingUtil {

    public static String utilPreviousInquiries(List<Inquiry> inquiriesList) {
        StringBuilder res = new StringBuilder();


        inquiriesList.forEach((inquiry) -> {
            res.append("<li class=\"list-group-item btn\"> <a style=\"display: block\" href=\"FrontController?command=chooseInquiry&inquiryId=")
                    .append(inquiry.getId())
                    .append("\">")
                    .append(inquiry.getId())
                    .append("</a></li> ");
        });
        
        return res.toString();
    }
}
