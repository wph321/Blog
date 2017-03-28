<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/popup_shuaxin_no.js" type="text/javascript"></script>
		
        <script language="javascript">
           function bowenDetail(id)
           {
                 var url="<%=path %>/bowenDetail.action?id="+id;
				 var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:300});
	             pop.setContent("contentUrl",url);
	             pop.setContent("title","博文内容");
	             pop.build();
	             pop.show();
           }
           function userDetail(userId)
           {
                 var url="<%=path %>/userDetail.action?userId="+userId;
				 var pop=new Popup({ contentType:1,isReloadOnClose:false,width:480,height:500});
	             pop.setContent("contentUrl",url);
	             pop.setContent("title","博主信息");
	             pop.build();
	             pop.show();
           }
           function pinglunMana_admin(bowenId)
           {
                 var url="<%=path %>/pinglunMana_admin.action?bowenId="+bowenId;
				 var pop=new Popup({ contentType:1,isReloadOnClose:false,width:600,height:500});
	             pop.setContent("contentUrl",url);
	             pop.setContent("title","评论管理");
	             pop.build();
	             pop.show();
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="55" background="<%=path %>/img/tbg.gif">&nbsp;博文管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="30%">标题</td>
					<td width="16%">内容</td>
					<td width="10%">发布时间</td>
					<td width="10%">博主</td>
					<td width="10%">评论</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.bowenList" id="bowen" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bowen.title"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <a style="color: red" href="#" onclick="bowenDetail(<s:property value="#bowen.id"/>)" class="pn-loperator">文章内容</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#bowen.shijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="userDetail(<s:property value="#bowen.userId"/>)" class="pn-loperator">博主信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="pinglunMana_admin(<s:property value="#bowen.id"/>)" class="pn-loperator">评论管理</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a class="pn-loperator" href="<%=path %>/bowenDel_admin.action?id=<s:property value="#bowen.id"/>">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
