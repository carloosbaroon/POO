package com.bolsaideas.springboot.errors.app.services;

import com.bolsaideas.springboot.errors.app.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista = new ArrayList<>();
        this.lista.add(new Usuario(1, "Aleph", "Baron"));
        this.lista.add(new Usuario(2, "Carlos", "Baron"));
        this.lista.add(new Usuario(3, "Pepa", "Baron"));
        this.lista.add(new Usuario(4, "Lalo", "Baron"));
        this.lista.add(new Usuario(5, "Luci", "Baron"));
    }

    @Override
    public List<Usuario> listar() {
        return lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;

        for (Usuario u: this.lista){
            if (u.getId().equals(id)){
                resultado = u;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = this.obtenerPorId(id);
        return Optional.ofNullable(usuario);
    }
}
