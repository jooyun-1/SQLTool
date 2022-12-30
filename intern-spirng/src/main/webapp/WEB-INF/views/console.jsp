<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><head>
<style>
/*
 * Copyright 2004-2022 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */

td, input, select, textarea, body, code, pre {
    font: 12px/1.4 Arial, sans-serif;
}

h1, h2, h3, h4, h5 {
    font: 12px/1.4 Arial, sans-serif;
    font-weight: bold;
}

a {
    text-decoration: none;
    color: #0000ff;
}

a:hover {
    text-decoration: underline;
}

body {
    margin: 4px;
}

code {
    background-color: #ece9d8;
    padding: 0px 2px;
}

h1 {
    background-color: #0000bb;
    padding: 2px 4px 2px 4px;
    color: #fff;
    font-size: 22px;
    line-height: normal;
}

h2 {
    font-size: 19px;
}

h3 {
    font-size: 16px;
}

li {
    margin-top: 6px;
}

ol {
    list-style-type: upper-roman;
    list-style-position: outside;
}

table {
    background-color: #ffffff;
    border-collapse: collapse;
    border: 1px solid #aca899;
}

td {
    background-color: #ffffff;
    padding: 2px;
    text-align: left;
    vertical-align:top;
    border: 1px solid #aca899;
}

textarea {
    width: 100%;
    overflow: auto;
}

th {
    font-weight: normal;
    text-align: left;
    background-color: #ece9d8;
    padding: 2px;
    border: 1px solid #aca899;
}

ul {
    list-style-type: disc;
    list-style-position: outside;
    padding-left: 20px;
}

.result {
    background-color: #f4f0e0;
    margin: 10px;
}

table.resultSet {
    white-space: pre;
}

.toolbar {
    background-color: #ece9d8;
}

table.toolbar {
    border-collapse: collapse;
    border: 0px;
    padding: 0px 0px;
}

th.toolbar {
    border: 0px;
}

tr.toolbar {
    border: 0px;
}

td.toolbar {
    vertical-align: middle;
    border: 0px;
    padding: 0px 0px;
}

table.nav {
    border: 0px;
}

tr.nav {
    border: 0px;
}

td.nav {
    border: 0px;
}

table.login {
    background-color: #ece9d8;
    border:1px solid #aca899;
}

tr.login {
    border: 0px;
}

th.login {
    color: #ffffff;
    text-align: left;
    border: 0px;
    background-color: #ece9d8;
    padding: 4px 10px;
    background-image: url(background.gif);
}

td.login {
    background-color: #ece9d8;
    padding: 5px 10px;
    text-align: left;
    border: 0px;
}

.iconLine {
    border-width:0px;
    border-style:solid;
}

.icon {
    border-top-color:#ece9d8;
    border-left-color:#ece9d8;
    border-right-color:#ece9d8;
    border-bottom-color:#ece9d8;
    border-width:1px;
    border-style:solid;
}

.icon_hover {
    border-color:#aca899;
    border-radius: 2px;
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-width:1px;
    border-style:solid;
}

table.empty {
    background-color: #ffffff;
    border: 0px;
}

td.empty {
    background-color: #ffffff;
    border: 0px;
    padding: 5px 10px;
    text-align: left;
}

.error {
    color: #771111;
}

div.error {
    background-color: #eecccc;
    border-color: #ddbbbb;
}

div.success {
    color: #226622;
    background-color: #cceecc;
    border-color: #bbddbb;
}

div.error, div.success {
    border-radius: 4px;
    padding: 10px;
    border-width: 1px;
    border-style: solid;
}

input.button {
    padding: 3px;
    background-color: #ece9d8;
    border-color: #aca899;
    border-radius: 2px;
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-width: 1px;
    border-style: solid;
}

input.button:hover {
    border-color: #5e5c55;
}

input.button:active {
    position:relative;
    top:1px;
}

.tree {
    border: 0px;
    vertical-align: middle;
    white-space: nowrap;
}

.tree img  {
    height: 18px;
    width: 18px;
    border: 0px;
    vertical-align: middle;
}

.tree a {
    border: 0px;
    text-decoration: none;
    vertical-align: middle;
    white-space: nowrap;
    color: #000000;
}

.tree a:hover {
    color: #345373;
}

table.content {
    width: 100%;
    height: 100%;
    border: 0px;
}

tr.content {
    border:0px;
    border-left:1px solid #aca899;
}

td.content {
    border:0px;
    border-left:1px solid #aca899;
}

.contentDiv {
    margin:10px;
}

tr.contentResult {
    border:0px;
    border-top:1px solid #aca899;
    border-left:1px solid #aca899;
}

td.contentResult {
    border:0px;
    border-top:1px solid #aca899;
    border-left:1px solid #aca899;
}

table.autoComp {
    background-color: #e0ecff;
    border: 1px solid #7f9db9;
    cursor: pointer;
    position: absolute;
    top: 1px;
    left: 1px;
    z-index:0;
    padding: 0px;
    margin: 0px;
    border-spacing:2px;
}

td.autoComp0 {
    border-spacing: 0px;
    padding: 1px 8px;
    background-color: #cce0ff;
    border: 0px;
}

td.autoComp1 {
    border-spacing: 0px;
    padding: 1px 8px;
    background-color: #e7f0ff;
    border: 0px;
}

td.autoComp2 {
    border-spacing: 0px;
    padding: 1px 8px;
    background-color: #ffffff;
    border: 0px;
}

td.autoCompHide {
    padding: 2px;
    display: none;
}

table.tool, table.tool tr, table.tool tr td {
    padding: 0px;
    border: 0px;
}
</style>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=0.9" />
    <title>H2 Console</title>
    <!--  link rel="stylesheet" type="text/css" href="stylesheet.css" />-->

</head>
<body style="margin: 20px">
    <form name="login" method="post" action="login.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42" id="login">
    <p>                    <select name="language" size="1"
                        onchange="javascript:document.location='index.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42&amp;language='+login.language.value;"
                    >
                    <option value="cs">&#268;e&#353;tina</option><option value="de">Deutsch</option><option value="en" selected>English</option><option value="es">Espa&#241;ol</option><option value="fr">Fran&#231;ais</option><option value="hi">Hindi &#2361;&#2367;&#2306;&#2342;&#2368;</option><option value="hu">Magyar</option><option value="ko">&#54620;&#44397;&#50612;</option><option value="in">Indonesia</option><option value="it">Italiano</option><option value="ja">&#26085;&#26412;&#35486;</option><option value="nl">Nederlands</option><option value="pl">Polski</option><option value="pt_BR">Portugu&#234;s (Brasil)</option><option value="pt_PT">Portugu&#234;s (Europeu)</option><option value="ru">&#1088;&#1091;&#1089;&#1089;&#1082;&#1080;&#1081;</option><option value="sk">Slovensky</option><option value="tr">T&#252;rk&#231;e</option><option value="uk">&#1059;&#1082;&#1088;&#1072;&#1111;&#1085;&#1089;&#1100;&#1082;&#1072;</option><option value="zh_CN">&#20013;&#25991; (&#31616;&#20307;)</option><option value="zh_TW">&#20013;&#25991; (&#32321;&#39636;)</option>
                    </select>
    &nbsp;&nbsp; <a href="admin.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42">Preferences</a>
<!--
-->
    &nbsp;&nbsp; <a href="tools.jsp?jsessionid=0efd4a099cae1be83f3cbd187844ea42">Tools</a>
    &nbsp;&nbsp; <a href="help.jsp?jsessionid=0efd4a099cae1be83f3cbd187844ea42">Help</a>
    </p>
        <table class="login" cellspacing="0" cellpadding="0">
            <tr class="login">
                <th class="login">Login</th>
                <th class="login"></th>
            </tr>
            <tr><td  class="login" colspan="2"></td></tr>
            <tr class="login">
                <td class="login">Saved Settings:</td>
                <td class="login">
                    <select name="setting" size="1"
                        style="width:300px"
                        onchange="javascript:document.location='index.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42&amp;setting='+login.setting.value;"
                    >
                    <option value="Generic H2 (Embedded)" selected>Generic H2 (Embedded)</option><option value="Generic H2 (Server)">Generic H2 (Server)</option><option value="Generic Derby (Embedded)">Generic Derby (Embedded)</option><option value="Generic Derby (Server)">Generic Derby (Server)</option><option value="Generic HSQLDB">Generic HSQLDB</option><option value="Generic MariaDB">Generic MariaDB</option><option value="Generic MySQL">Generic MySQL</option><option value="Generic PostgreSQL">Generic PostgreSQL</option><option value="Generic MS SQL Server 2005">Generic MS SQL Server 2005</option><option value="Generic MS SQL Server 2000">Generic MS SQL Server 2000</option><option value="Generic Oracle">Generic Oracle</option><option value="Generic DB2">Generic DB2</option><option value="Generic SQLite">Generic SQLite</option><option value="Generic Firebird Server">Generic Firebird Server</option><option value="Generic Azure SQL">Generic Azure SQL</option><option value="Generic Hive">Generic Hive</option><option value="Generic Hive 2">Generic Hive 2</option><option value="Generic Impala">Generic Impala</option><option value="Generic Redshift">Generic Redshift</option><option value="Generic Snowflake">Generic Snowflake</option><option value="Generic Teradata">Generic Teradata</option><option value="Generic JNDI Data Source">Generic JNDI Data Source</option>
                    </select>
                </td>
            </tr>
            <tr class="login">
                <td class="login">Setting Name:</td>
                <td class="login">
                    <input type="text" name="name" value="Generic H2 (Embedded)" style="width:200px;" />
                    <input type="button" class="button" value="Save" onclick="javascript:document.login.action='settingSave.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42';submit()" />
                    <input type="button" class="button" value="Remove" onclick="javascript:document.login.action='settingRemove.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42';submit()" />
                </td>
            </tr>
            <tr class="login">
                <td class="login" colspan="2">
                    <hr />
                </td>
            </tr>
            <tr class="login">
                <td class="login">Driver Class:</td>
                <td class="login"><input type="text" name="driver" value="org.h2.Driver" style="width:300px;" /></td>
            </tr>
            <tr class="login">
                <td class="login">
                    <a href="#" onclick="var x=document.getElementById('url').style;x.display=x.display==''?'none':'';">
                        JDBC URL</a>:</td>
                <td class="login"><input type="text" name="url" value="jdbc:h2:./test" style="width:300px;" /></td>
            </tr>
            <tr class="login">
                <td class="login">User Name:</td>
                <td class="login"><input type="text" name="user" value="sa" style="width:200px;" /></td>
            </tr>
            <tr class="login">
                <td class="login">Password:</td>
                <td class="login"><input type="password" name="password" value="" style="width:200px;" /></td>
            </tr>
            <tr class="login">
                <td class="login"></td>
                <td class="login">
                    <input type="submit" class="button" value="Connect" />
                    &nbsp;
                    <input type="button" class="button" value="Test Connection" onclick="javascript:document.login.action='test.do?jsessionid=0efd4a099cae1be83f3cbd187844ea42';submit()" />
                    <br />
                    <br />
                </td>
            </tr>
        </table>
        <br />
        <div id="url" style="display: none">
            <h2>H2 Database URLs</h2>
            <h3>Embedded</h3>
            <p>
            The URL <code>jdbc:h2:~/test</code> means the database is stored in
            the user home directory in files starting with 'test'.
            Absolute locations like <code>jdbc:h2:/data/db/test</code> are supported.
            In embedded mode, the database runs in the same process as the application.
            Only one process may access a database at any time.
            Databases are automatically created if they don't exist
            <a target="_blank" href="https://h2database.com/html/tutorial.html#creating_new_databases">if you have a permission</a>.
            URLs of the form <code>jdbc:h2:./data/test</code> are relative to
            the current working directory (the directory where the application was started).
            It is recommended to use locations relative to <code>~</code>
            or absolute locations.
            </p>

            <h4>Remote (client/server)</h4>
            <p>
            The URL <code>jdbc:h2:tcp://localhost/~/test</code> means connect
            over TCP/IP to the H2 TCP server running on this computer, and open a database
            called test in the user home directory. The server must be started first.
            Any number of clients can connect to the same database.
            The same location rules as for embedded databases apply.
            </p>

            <h4>In-Memory</h4>
            <p>
            The URL <code>jdbc:h2:mem:test</code> means open an in-memory database
            named 'test'. Data is not persisted, and lost when the last connection to the database
            is closed. Multiple threads can access the same database, but data is only visible
            within the same process.
            </p>

            <p>
            For more information, see <a target="_blank" href="https://h2database.com/html/features.html#database_url">Database URL Overview</a>.
            </p>
        </div>
        <p class="error"></p>
    </form>
</body></html>