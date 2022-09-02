package br.com.bb.crv.rest;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.bb.crv.models.CRVS0053;
import br.com.bb.crv.dao.CRVS0053Dao;;

@RequestScoped
@Path("/crvs0053")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class CRVS0053Resource {


    @Inject
    CRVS0053Dao dao;

    @GET
    @Operation(summary = "Listar CRVS",
            description = "Retorna uma lista de CRVS")
    @APIResponse(
            responseCode = "200",
            description = "CRVS",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CRVS0053.class, type = SchemaType.ARRAY))})
    public Response buscarCRVS0053() throws Exception  {
        return Response.status(Response.Status.OK).entity(dao.buscarCRVS0053()).build();
    } 

   

    @POST
    @Operation(summary = "inserir CRVS0053",
            description = "DESC")
    @APIResponse(
            responseCode = "200",
            description = "CRV",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CRVS0053.class))})
    public Response solicitarCRVS0053(CRVS0053 book) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.inserirCRVS0053(book)).build();
    }

    @PUT
    @Path("/atualiza")
    @Operation(summary = "atualizacao de registro",
            description = "atualizacao de registro")
    @APIResponse(
            responseCode = "200",
            description = "CRV UPDATE",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CRVS0053.class))})
    public Response merge(CRVS0053 book) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.mergeRegistro(book)).build();
    }

    @PUT
    @Path("/processa")
    @Operation(summary = "Processar CRVS",
            description = "Retorna uma lista de CRVS")
    @APIResponse(
            responseCode = "200",
            description = "CRVS",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CRVS0053.class))})
    public Response processamentoCRVS0053() throws Exception  {
        return Response.status(Response.Status.OK).entity(dao.processamentoCRVS0053()).build();
    } 

    @PUT
    @Path("/atualizaWhere")
    @Operation(summary = "atualizacao de registro",
            description = "atualizacao de registro")
    @APIResponse(
            responseCode = "200",
            description = "CRV UPDATE",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CRVS0053.class))})
    public Response mergeVerticeWhere(CRVS0053 book) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.mergeVerticeWhere(book)).build();
    }

    @DELETE
    @Path("/deletar/{id}")
    @Operation(summary = "remoção de registro",
            description = "remoção de registro")
    @APIResponse(
            responseCode = "200",
            description = "CRV delete",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CRVS0053.class))})
    public Response delete(final @PathParam("id") int id) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.deletarRegistro(id)).build();
    }

    
/* 
    @POST
    @Path("/{id}")
    @Operation(summary = "Criar cartão",
            description = "Criação de cartões")
    @APIResponse(
            responseCode = "201",
            description = "Cartões",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Mensagem.class))})
        public Response criarCartao(final @PathParam("id") int id) throws Exception {
                return Response.status(Response.Status.CREATED).entity(service.criarCartao(id)).build();
        } */

  /*  
  
    */


   /*  @GET
    @Path("/{id}")
    @Operation(summary = "Listar cartões por ID",
            description = "Listar todos os cartões criados para o id solicitado")
    @APIResponse(
            responseCode = "200",
            description = "Cartões",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Cartao.class, type = SchemaType.ARRAY))})
    public Response buscarCartoesById(final @PathParam("id") int id ) throws Exception {
        return  Response.status(Response.Status.OK).entity(dao.buscarCartoes(id)).build();
    }
 */
}
