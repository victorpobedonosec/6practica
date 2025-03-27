package com.example.practuhv3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practuhv3.activity.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var posts = listOf(
        Post(
            id = 1,
            author = "БТПИТ Борисоглебский техникум промышленных информационных технологий",
            content = "ГБПОУ ВО «БТПИТ» образовано в соответствии с  постановлением правительства Воронежской области от 20 мая 2015 года № 401 в результате реорганизации в  форме слияния государственного образовательного бюджетного учреждения среднего профессионального образования Воронежской области «Борисоглебский индустриальный техникум», государственного образовательного бюджетного учреждения среднего профессионального образования Воронежской области",
            published = "22 марта  18:22",
            likedByMe = false
        ),
        Post(
            id = 2,
            author = "БТПИТ Борисоглебский техникум промышленных информационных технологий",
            content = "ГБПОУ ВО «БТПИТ» образовано в соответствии с  постановлением правительства Воронежской области от 20 мая 2015 года № 401 в результате реорганизации в  форме слияния государственного образовательного бюджетного учреждения среднего профессионального образования Воронежской области «Борисоглебский индустриальный техникум», государственного образовательного бюджетного учреждения среднего профессионального образования Воронежской области",
            published = "22 марта  18:22",
            likedByMe = false
        ),
    )
    private val data = MutableLiveData(posts)
    override fun get(): LiveData<List<Post>> = data

    override fun like(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(
                likedByMe = !it.likedByMe,
                likes = if (it.likedByMe) it.likes - 1 else it.likes + 1
            )
        }
        data.value = posts
    }

    override fun share(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(shares = it.shares + 1)
        }
        data.value = posts
    }
}

 // override fun like() {
 //     post = post.copy(
 //         likedByMe = !post.likedByMe,
 //         likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
 //     )
 //     data.value = post
 // }

 //  override fun share() {
 //
 //  }
