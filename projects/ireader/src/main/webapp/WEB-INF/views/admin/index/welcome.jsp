<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<style>

    legend {
        cursor: pointer;
    }
    .fc-button-add {
        margin-right: 10px!important;
    }

    #loading {
        position: absolute;
        top: 5px;
        right: 5px;
    }

    .ui-dialog {
        overflow: visible!important;
    }
    .ui-dialog-content {
        overflow: visible!important;
    }

    #calendar {
        width: 750px;
        margin: 0 auto;
    }
</style>
<div  style="margin: 5px;margin-top: 10px;">
    <div class="row-fluid tool ui-toolbar">
        <div style="padding-left: 10px;">
            <a class="btn btn-link btn-view-info" data-toggle="tooltip" data-placement="bottom" title="点击查看个人资料/修改密码">
            </a>
            <span class="muted">|</span>
            &nbsp;
            <span class="muted">
                您有
                <a class="btn btn-link btn-view-message no-padding" data-toggle="tooltip" data-placement="bottom" title="点击查看未读消息">
                    <span class="badge badge-important">${messageUnreadCount}条</span>
                </a>
                未读消息
            </span>
        </div>
    </div>
    <br/>


    <br/>
    <br/>
    <br/>

</div>
