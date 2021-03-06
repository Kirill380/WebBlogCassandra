package com.redkite.blog.dao;

import com.redkite.blog.model.Comment;
import com.redkite.blog.model.Post;
import com.redkite.blog.model.Vote;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PostDao extends AbstractCassandraDao<Post, UUID> {

    @Override
    protected Class<Post> getColumnFamilyClass() {
        return Post.class;
    }

    @Override
    protected String getColumnFamilyName() {
        return "post";
    }


    public Post create(Post post) {
        post.setId(UUID.randomUUID());
        return super.save(post);
    }


    public void addVote(UUID id, Vote vote) {
        Post post = find(id);
        post.getVotes().add(vote);
        save(post);
    }

    public void addComment(UUID id, Comment comment) {
        Post post = find(id);
        post.getComments().add(comment);
        save(post);
    }

    public void deletePost(UUID id) {
        super.remove(id);
    }
}
