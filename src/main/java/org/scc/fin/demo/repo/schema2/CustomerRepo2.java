package org.scc.fin.demo.repo.schema2;

import org.scc.fin.demo.model.entity.schema2.CustomerEntity2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo2 extends JpaRepository<CustomerEntity2, String> {

}
