package cn.yrm.ss.page;

/**
 * 分页参数类
 * @author 湖畔微风
 *         Edit by XUQIAN 2014-04-22
 */
public class PageParameter {

    /** 默认分页 每页记录数 10 */
    public static final int DEFAULT_PAGE_SIZE = 10;

    // 每页记录数
    private int pageSize;
    // 当前页
    private int currentPage;
    // 上一页
    private int prevPage;
    // 下一页
    private int nextPage;
    // 总页数
    private int totalPage;
    // 总记录数
    private int totalCount;

    public PageParameter() {
        this(1, DEFAULT_PAGE_SIZE);
    }

    public PageParameter(int currentPage) {
        this(currentPage, DEFAULT_PAGE_SIZE);
    }

    /**
     * @param currentPage 当前获取页码
     * @param pageSize 每页记录数
     */
    public PageParameter(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.nextPage = currentPage + 1;
        this.prevPage = currentPage - 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.nextPage = currentPage + 1;
        this.prevPage = currentPage - 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return prevPage;
    }

    public void setPrePage(int prePage) {
        this.prevPage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
