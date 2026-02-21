package com.waiyan;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> listAll() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public Product add(Product product) {
        product.persist();
        return product;
    }

    @GET
    @Path("/{id}")
    public Product getOne(@PathParam("id") Long id) {
        return Product.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Product update(@PathParam("id") Long id, Product product) {
        Product entity = Product.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.name = product.name;
        entity.price = product.price;
        entity.quantity = product.quantity;
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Product.deleteById(id);
    }
}