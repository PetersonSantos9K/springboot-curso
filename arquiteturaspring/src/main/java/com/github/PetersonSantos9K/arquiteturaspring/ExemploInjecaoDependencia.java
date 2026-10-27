package com.github.PetersonSantos9K.arquiteturaspring;

import com.github.PetersonSantos9K.arquiteturaspring.todos.*;
import com.sun.jdi.connect.spi.Connection;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ExemploInjecaoDependencia {

    static void main() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        Connection conn = (Connection) dataSource.getConnection();

        EntityManager em = null;

        TodoRepository repository = null; // new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender sender = new MailSender();
        TodoService todoService = new TodoService(repository, todoValidator, sender);

    }
}
