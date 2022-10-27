package org.scc.fin.demo.rest;

import org.scc.fin.demo.model.dto.Customer;
import org.scc.fin.demo.rest.base.BaseRestController;
import org.scc.fin.demo.service.CustomerService1;
import org.scc.fin.demo.service.CustomerService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("schema2")
public class CustomerController2 extends BaseRestController {

    @Autowired
    private CustomerService2 customerService2;

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String index(HttpServletRequest request) throws UnknownHostException {
        return "Application is up at: http://" + InetAddress.getLocalHost().getHostAddress() + ":" + serverPort;
    }

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> list(HttpServletRequest request) {
        return customerService2.list();
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postEndpoint(@Valid @RequestBody Customer dto, Errors errors) {
        if (errors.hasErrors()) {
            final String errorMessage = getErrorMessage(errors.getAllErrors());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }

        return customerService2.create(dto);
    }

    @PutMapping(value = "/customer/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Customer putEndpoint(@PathVariable String id, @Valid @RequestBody Customer dto, Errors errors) {
        if (errors.hasErrors()) {
            final String errorMessage = getErrorMessage(errors.getAllErrors());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
        return customerService2.update(dto);
    }

    @DeleteMapping(value = "/customer/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteEndpoint(@PathVariable String id) {
        customerService2.delete(id);
    }
}