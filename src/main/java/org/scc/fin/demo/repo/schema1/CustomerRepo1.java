package org.scc.fin.demo.repo.schema1;

import org.scc.fin.demo.model.entity.schema1.CustomerEntity1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo1 extends JpaRepository<CustomerEntity1, String> {

}
