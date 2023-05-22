
package infoemployee;


public class testingEmployee {
    
    //private int emp_id;
    private String first_name;
    private String last_name;
    private String emp_city;
    private int emp_phone;
    private int emp_salary;
    
    public testingEmployee(String first_name,String last_name,String emp_city,int emp_phone,int emp_salary){
        //this.emp_id=emp_id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.emp_city=emp_city;
        this.emp_phone=emp_phone;
        this.emp_salary=emp_salary;
    }

//    public int getEmp_id() {
//        return emp_id;
//    }
//
//    public void setEmp_id(int emp_id) {
//        this.emp_id = emp_id;
//    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public int getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(int emp_phone) {
        this.emp_phone = emp_phone;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(int emp_salary) {
        this.emp_salary = emp_salary;
    }
    
    
    
}
