package it.impara.blogging.post;

import it.impara.blogging.general.responses.CreateResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    //questo serve per il metodo GET
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //creo ora la parte di POST ma prima devo creare il PostRequest

    public CreateResponse save(PostRequest request) {
        Post post = new Post();
        BeanUtils.copyProperties(post, request);
        postRepository.save(post);

        CreateResponse response = new CreateResponse();
        BeanUtils.copyProperties(request, response);
        return response;
    }

    // adesso creo il modo per trovarne uno specifico con l'ID

    public Post findById(Long id) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Tecnico non trovato");
        return postRepository.findById(id).get();
    }

    // creo il metodo DELETE per eliminare un elemento
    public void delete(Long id){
        Post post = new Post();
        postRepository.deleteById(id);
    }

    // ora creo il metodo PUT per modificare

    public PostRequest modify(Long id, PostRequest request) {
        Post post = new Post();
        BeanUtils.copyProperties(request, id);
        postRepository.save(post);
        return request;
    }
}
