package com.example.repository;

import com.example.SessionUtil;
import com.example.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
//    private static final List<Product> productList;

//    static {
//        productList = new ArrayList<>();
//        productList.add(new Product(1, "Moto", "10000", "perfect", "Yamaha"));
//        productList.add(new Product(2, "Car", "120000", "perfect", "Toyota"));
//        productList.add(new Product(3, "Moto", "15000", "perfect", "Honda"));
//
//    }

    @Override
    public List<Product> findAll(String search) {
//        List<Product> products = new ArrayList<>();
//        if (search == null) {
//            return productList;
//        }
//        for (Product product : productList) {
//            if (product.getName().contains(search)) {
//                products.add(product);
//            }
//        }
//        return products;

        Session session = null;
        List<Product> products = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            products = session.createQuery("from Product where name like concat('%', :name, '%')")
                    .setParameter("name", search).getResultList();
//            productList = session.createQuery("from Product where name like concat('%', ?1, '%')").
//                    setParameter(1,freeText).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    @Override
    public void create(Product product) {
//        productList.add(product);
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
//        for (Product product : productList) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
        TypedQuery<Product> query = SessionUtil.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void edit(Product product) {
//        for (Product product1 : productList) {
//            if (product1.getId() == product.getId()) {
//                product1.setName(product.getName());
//                product1.setPrice(product.getPrice());
//                product1.setProductDescription(product.getProductDescription());
//                product1.setProducer(product.getProducer());
//            }
//        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setProductDescription(product.getProductDescription());
            product1.setProducer(product.getProducer());
            session.saveOrUpdate(product1);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
//        Product product = this.findById(id);
//        if (product != null) {
//            productList.remove(product);
//        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(id);
            session.remove(product1);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
