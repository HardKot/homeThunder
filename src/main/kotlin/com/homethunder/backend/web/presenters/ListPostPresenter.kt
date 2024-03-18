package com.homethunder.backend.web.presenters

import com.homethunder.backend.repository.PostRepository
import com.homethunder.backend.web.views.posts.ListPostView
import org.springframework.stereotype.Component


@Component
class ListPostPresenter(
    private val postRepository: PostRepository
) {

    private lateinit var view: ListPostView

    fun setView(view: ListPostView) {
        this.view = view

//        view.postList.setItems(postRepository.findAll().toMutableList())
    }
}
