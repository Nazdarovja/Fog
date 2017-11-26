/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class Inquiry {

    private int id;
    private int carportHeight;
    private int carportLength;
    private int carportWidth;
    private int shackWidth;
    private int shackLength;
    private String roofType;  //enum
    private String angle;          //enum
    private String commentCustomer;
    private String commentEmployee;
    private Date period;
    private String status;      //enum
    private String email;
    private int id_employee;
    private BillOfMaterials bom;
    private Timestamp date;

    public Inquiry(int id, int carportHeight, int carportLength, int carportWidth, int shackWidth, int shackLength, String roofType, String angle, String commentCustomer, String commentEmployee, Date period, String status, String email, int id_employee) {
        this.id = id;
        this.carportHeight = carportHeight;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        this.shackWidth = shackWidth;
        this.shackLength = shackLength;
        this.roofType = roofType;
        this.angle = angle;
        this.commentCustomer = commentCustomer;
        this.commentEmployee = commentEmployee;
        this.period = period;
        this.status = status;
        this.email = email;
        this.id_employee = id_employee;
    }

    public int getId() {
        return id;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public BillOfMaterials getBom() {
        return bom;
    }

    public void setBom(BillOfMaterials bom) {
        this.bom = bom;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public int getShackWidth() {
        return shackWidth;
    }

    public int getShackLength() {
        return shackLength;
    }

    public String getRoofType() {
        return roofType;
    }

    public String getAngle() {
        return angle;
    }

    public String getCommentCustomer() {
        return commentCustomer;
    }

    public String getCommentEmployee() {
        return commentEmployee;
    }

    public Date getPeriod() {
        return period;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public int getId_employee() {
        return id_employee;
    }

    public Timestamp getDate() {
        return date;
    }


}