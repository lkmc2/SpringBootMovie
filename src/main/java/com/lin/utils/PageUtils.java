package com.lin.utils;

/**
 * 分页工具
 * @author lkmc2
 */
public class PageUtils {
    /**
     * 生成分页代码
     * @param targetUrl 目标地址
     * @param totalNum 总记录数
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @return 分页代码
     */
    public static String generatePagination(String targetUrl, int totalNum, int currentPage, int pageSize) {
        int totalPage = (totalNum % pageSize == 0) ? (totalNum / pageSize) : (totalNum / pageSize + 1);

        if (totalPage == 0) {
            return "未查询到数据";
        }

        StringBuilder pageCode = new StringBuilder();
        pageCode.append(String.format("<li><a href='%s/1'>首页</a></li>", targetUrl));
        if (currentPage > 1) {
            // 有上一页时
            pageCode.append(String.format("<li><a href='%s/%s'>上一页</a></li>", targetUrl, currentPage - 1));
        } else {
            // 无上一页时
            pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
        }

        for (int i = currentPage - 2; i <= currentPage + 2; i++) {
            if (i < 1 || i > totalPage) {
                continue;
            }

            if (i == currentPage) {
                // 是当前页
                pageCode.append(String.format("<li class='active'><a href='%s/%s'>%s</a></li>", targetUrl, i, i));
            } else {
                // 不是当前页
                pageCode.append(String.format("<li><a href='%s/%s'>%s</a></li>", targetUrl, i, i));
            }
        }

        if (currentPage < totalPage) {
            // 有下一页时
            pageCode.append(String.format("<li><a href='%s/%s'>下一页</a></li>", targetUrl, currentPage + 1));
        } else {
            // 无下一页时
            pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
        }

        pageCode.append(String.format("<li><a href='%s/%s'>尾页</a></li>", targetUrl, totalPage));
        return pageCode.toString();
    }
}
