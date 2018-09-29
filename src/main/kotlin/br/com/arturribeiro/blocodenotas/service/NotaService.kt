package br.com.arturribeiro.blocodenotas.service

import br.com.arturribeiro.blocodenotas.model.Nota
import br.com.arturribeiro.blocodenotas.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.stereotype.Service

@Service
class NotaService {

    @Autowired
    lateinit var notaRepository: NotaRepository

    fun salvar(nota: Nota): Nota{
        return notaRepository.save(nota)
    }

    fun buscarTodos() : List<Nota> {
        return notaRepository.findAll()
    }

    fun apagar(id: String){
        notaRepository.deleteById(id)
    }

    fun buscarPor(id: String): Nota{
        return notaRepository.findById(id).get()
    }

    fun buscarPorTitulo(titulo:String): List<Nota> {
        return notaRepository.findByTituloContainingCase(titulo)
    }
}