package it.impara.blogging.post;

import it.impara.blogging.general.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    //sto ritrovando tutti i post
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAll() {
        return postService.findAll();
    }

    // ritrova solo i post con l'id desiderato
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post findById(Long id) {
        return postService.findById(id);
    }

    // crea un nuovo post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(PostRequest request) {
        return postService.save(request);
    }

    // elimina un post
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    //modifica un post
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostRequest modify(@PathVariable Long id, PostRequest request) {
        return postService.modify(id, request);
    }



}
