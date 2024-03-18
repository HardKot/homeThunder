package com.homethunder.backend.web.views.posts


import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.homethunder.backend.domain.entity.Post
import com.homethunder.backend.web.components.MainLayout
import com.homethunder.backend.web.presenters.ListPostPresenter
import com.vaadin.flow.component.orderedlayout.VerticalLayout

import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import jakarta.annotation.PostConstruct
import jakarta.annotation.security.PermitAll


@Route("posts", layout = MainLayout::class)
@PageTitle("Новости")
@PermitAll
class ListPostView(
    private val listPostPresenter: ListPostPresenter
) : KComposite() {

    private lateinit var postList: VerticalLayout

    init {
        ui {
            div {
                postList = verticalLayout {

                }


            }

        }

    }



    @PostConstruct
    fun postConstruct() {
        listPostPresenter.setView(this)
    }

    fun addPostCard(post: Post) {
        postList.add(ui {
            verticalLayout {

            }
        })
    }
}
