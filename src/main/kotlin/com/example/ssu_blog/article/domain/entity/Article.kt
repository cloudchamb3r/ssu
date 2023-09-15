package com.example.ssu_blog.article.domain.entity

import com.example.ssu_blog.user.domain.entity.UserModel
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "article")
class Article (
    content: String,
    title: String,
    userId: UserModel
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val articleId: Long? = null

    @Column(nullable = false)
    var content: String = content

    @Column(nullable = false)
    var title: String = title

    @ManyToOne
    @JoinColumn(name  = "user_id", nullable = false)
    val userId: UserModel = userId

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
}