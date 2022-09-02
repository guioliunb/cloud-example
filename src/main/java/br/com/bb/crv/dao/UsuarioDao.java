package br.com.bb.crv.dao;

import br.com.bb.crv.exceptions.ErroSqlException;
import br.com.bb.crv.models.Usuario;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Traced
@RequestScoped
public class UsuarioDao {

    @PersistenceContext
    EntityManager em;

    public List<Usuario> buscaUsuarios() throws ErroSqlException {
        String nameQuery = "CONSULTAR_USUARIO";

        TypedQuery<Usuario> query = em
                .createNamedQuery(nameQuery, Usuario.class);

        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<>();
        } catch (PersistenceException e){
            throw new ErroSqlException(e);
        }
    }

    public Usuario buscarUsuario(Long id) throws ErroSqlException {
        String nameQuery = "CONSULTAR_USUARIO_ID";

        TypedQuery<Usuario> query = em
                .createNamedQuery(nameQuery, Usuario.class);

        query.setParameter("idUsuario", id);

        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } catch (PersistenceException e){
            throw new ErroSqlException(e);
        }
    }

    @Transactional
    public int inserirUsuario(Usuario usuario) throws ErroSqlException {
        String nameQuery = "INSERIR_USUARIO";
        return insertOrUpdate(usuario, nameQuery);
    }

    @Transactional
    public int excluirUsuario(long id) throws ErroSqlException {
        String nameQuery = "EXCLUIR_USUARIO";

        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("idUsuario", id);

        try {
            return query.executeUpdate();
        } catch (NoResultException e){
            return 0;
        } catch (PersistenceException e){
            throw new ErroSqlException(e);
        }
    }

    @Transactional
    public int atualizarUsuario(Usuario usuario) throws ErroSqlException {
        String nameQuery = "ATUALIZAR_USUARIO";
        return insertOrUpdate(usuario, nameQuery);
    }

    @Transactional
    private int insertOrUpdate(Usuario usuario, String nameQuery) throws ErroSqlException {
        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("idUsuario", usuario.getId());
        query.setParameter("nomeUsuario", usuario.getNome());
        query.setParameter("dataNascimento", usuario.getNascimento());

        try {
            return query.executeUpdate();
        } catch (NoResultException e) {
            return 0;
        } catch (PersistenceException e) {
            throw new ErroSqlException(e);
        }
    }
}
