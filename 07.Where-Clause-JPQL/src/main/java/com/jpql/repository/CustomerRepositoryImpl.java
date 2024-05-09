package com.jpql.repository;

import com.jpql.dto.CustomerDTO;
import com.jpql.entity.Customers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Repository(value="customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerDTO> getCustomerDetails() {
    /*
        below code for using positional parameter

        String queryString = "select c from Customers c where c.customerId=?1";
        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, 1001);
        List<Customers> customers = query.getResultList();

        //below code for using named parameter
        String queryString1 = "SELECT c FROM Customers c WHERE c.customerId=:custId";
        Query query = entityManager.createQuery(queryString1);
        query.setParameter("custId", 1002);
        List<Customers> customers = query.getResultList();
    */
        String queryString1 = "select c from Customers c where c.customerId=1002";
        String queryString2 = "select c from Customers c where c.city!='Pune'";
        //To compare date in DB and DateTime in entity class we need to parse it to same format
        String dateString = "1990-01-01";
        LocalDate localDateToCompare = LocalDate.parse(dateString);

        String queryString3 = "select c from Customers c where c.dateOfBirth > ?1";
        String queryString4 = "select c from Customers c where c.dateOfBirth >= ?1";
        String queryString5 = "select c from Customers c where c.dateOfBirth < ?1";
        String queryString6 = "select c from Customers c where c.dateOfBirth <= ?1";

        String date1= "1990-01-01";
        LocalDate localDate1 = LocalDate.parse(date1);
        String date2 = "1995-01-01";
        LocalDate localDate2 = LocalDate.parse(date2);

        String queryString7 = "SELECT c FROM Customers c WHERE c.dateOfBirth BETWEEN :startDate AND :endDate";
         String queryString8 = "select c from Customers c where c.name LIKE '%e%'";
        String queryString9 = "select c from Customers c where c.emailId IS NULL";
        String queryString10 = "select c from Customers c where c.city IN ('Pune', 'Delhi')";

        Query query = entityManager.createQuery(queryString10);
    //    query.setParameter(1,localDateToCompare);    this for queryString3 to 6
    /* below two comment line is for queryString7
       query.setParameter("startDate", localDate1);
        query.setParameter("endDate", localDate2);

     */
        List<Customers> customers = query.getResultList();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customers customer:customers){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTO.setCity(customer.getCity());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
