package br.com.bb.crv.services;

import br.com.bb.crv.dao.UsuarioDao;
import br.com.bb.crv.dao.UsuarioDao;
import br.com.bb.dev.ext.exceptions.ErroNegocialException;
import br.com.bb.crv.exceptions.ChavesMonitoradasSistema;
import br.com.bb.crv.exceptions.ErrosSistema;
import br.com.bb.crv.exceptions.ErroSqlException;
import br.com.bb.crv.models.Usuario;
import io.opentracing.Tracer;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;

@RequestScoped
@Traced
public class UsuarioService {

    private static final Integer IDADE_MINIMA_PARA_MAIORIDADE = 18;
    private static final String TAG_TRACE_ERRO = "erro";
    private static final String TAG_TRACE_USUARIO = "usuario";
    private static final String ZONE_UTC = "UTC";

    @Inject
    UsuarioDao dao;

    @Inject
    Tracer configuredTracer;

    private void validarUsuario(Usuario usuario) throws ErroNegocialException {

        if(usuario.getNascimento() == null){
            addTracerTag(TAG_TRACE_ERRO, ErrosSistema.INFORME_DATA_NASCIMENTO.toString());
            addTracerTag(TAG_TRACE_USUARIO, usuario.toString());
            throw new ErroNegocialException(ErrosSistema.INFORME_DATA_NASCIMENTO.get());
        }

        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - usuario.getNascimento().toInstant().atZone(ZoneId.of(ZONE_UTC)).getYear();

        if( idade < IDADE_MINIMA_PARA_MAIORIDADE){
            addTracerTag(TAG_TRACE_ERRO, ErrosSistema.ERRO_INCLUSAO_USUARIO.toString());
            addTracerTag(TAG_TRACE_USUARIO, usuario.toString());
            throw new ErroNegocialException(ErrosSistema.ERRO_INCLUSAO_USUARIO.get().addVariavel(
                ChavesMonitoradasSistema.IDADE.get(),IDADE_MINIMA_PARA_MAIORIDADE.toString()));        }
    }

    private void addTracerTag(String nomeTag, String valorTag){
        if(configuredTracer != null && configuredTracer.activeSpan() != null) {
            configuredTracer.activeSpan().setTag(TAG_TRACE_USUARIO, valorTag);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public int inserirUsuario(Usuario usuario) throws ErroNegocialException, ErroSqlException {
        validarUsuario(usuario);
        return dao.inserirUsuario(usuario);
    }

    @Transactional(rollbackOn = Exception.class)
    public int atualizarUsuario(long id, Usuario usuario) throws ErroNegocialException {
        usuario.setId(id);
        validarUsuario(usuario);
        return dao.atualizarUsuario(usuario);
    }

    @Transactional(rollbackOn = Exception.class)
    public int excluirUsuario(Long id) throws ErroNegocialException, ErroSqlException {
        // Exemplo de regra para lancar exceção
        if(id == 1){
            throw new ErroNegocialException(ErrosSistema.ERRO_EXCLUSAO_USUARIO.get().addVariavel(
                ChavesMonitoradasSistema.CPF.get(), id.toString()));
        }

        return dao.excluirUsuario(id);
    }
}
