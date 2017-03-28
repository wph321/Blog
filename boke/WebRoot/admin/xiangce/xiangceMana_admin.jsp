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
           function zhaopianMana_admin(xiangceId)
           {
                 var url="<%=path %>/zhaopianMana_admin.action?xiangceId="+xiangceId;
				 var pop=new Popup({ contentType:1,isReloadOnClose:false,width:600,height:400});
	             pop.setContent("contentUrl",url);
	             pop.setContent("title","照片管理");
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
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="55" background="<%=path %>/img/tbg.gif">&nbsp;相册信息管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					<td width="30%">相册名称</td>
					<td width="10%">博主信息</td>
					<td width="10%">照片管理</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.xiangceList" id="xiangce" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#xiangce.name"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="userDetail(<s:property value="#xiangce.userId"/>)" class="pn-loperator">博主信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="zhaopianMana_admin(<s:property value="#xiangce.id"/>)" class="pn-loperator">照片管理</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a class="pn-loperator" href="<%=path %>/xiangceDel.action?id=<s:property value="#xiangce.id"/>">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
