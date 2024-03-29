package com.wuzz.demo.dao;

import com.wuzz.demo.associate.AuthorAndBlog;
import com.wuzz.demo.associate.BlogAndAuthor;
import com.wuzz.demo.associate.BlogAndComment;
import com.wuzz.demo.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: qingshan
 * @Date: 2019/2/23 17:54
 * @Description: 咕泡学院，只为更好的你
 */

@Repository
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);


    /**
     * 新增博客
     * @param blog
     * @return
     */
    public int insertBlog(Blog blog);

    /**
     * 新增博客
     * @param blog
     * @return
     */
    public int insertBlogs(List<Blog> blog);

    /**
     * 根据博客查询作者，一对一，嵌套结果
     * @param bid
     * @return
     */
    public List<BlogAndAuthor> selectBlogWithAuthorResult(Integer bid);

    /**
     * 根据博客查询作者，一对一，嵌套查询，存在N+1问题
     * @param bid
     * @return
     */
    public BlogAndAuthor selectBlogWithAuthorQuery(Integer bid);

    /**
     * 查询文章带出文章所有评论（一对多）
     * @param bid
     * @return
     */
    public BlogAndComment selectBlogWithCommentById(Integer bid);

    /**
     * 查询作者带出博客和评论（多对多）
     * @return
     */
    public List<AuthorAndBlog> selectAuthorWithBlog();


    /**
     * 根据主键查询文章
     * @param blog
     * @return
     */
    public Blog selectBlogById2(Blog blog);



}
