<%
  if (request.isUserInRole("mapper")) {
    response.sendRedirect(request.getContextPath()+"/mapper/");
    return;
  }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html >
<html lang="de">
    <head>
        <title>Stachys</title>
        <meta charset="utf-8" />
        <meta name="Content-Language" content="de" >
        <meta name="COPYRIGHT" content="Copyright (c) 2011 by Stachys" >
        <meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
        <meta name="KEYWORDS" content="" >
        <meta name="DESCRIPTION" content="description" >
        <meta name="ROBOTS" content="INDEX, FOLLOW" >
        <!--        <link type="text/css" href="css/ui-lightness/jquery-ui-1.8.11.custom.css" rel="stylesheet" />-->
        <!--        <link rel="stylesheet" href="css/globals.css"  >
                <link rel="stylesheet" href="css/locals.css"  >-->
        <link rel="stylesheet" href="css/style.css"  >
        <link rel="shortcut icon" href="sprenticon.png">
        
        <!--[if lt IE 9]>
<script>
  var e = ("abbr,article,aside,audio,canvas,datalist,details," +
    "figure,footer,header,hgroup,mark,menu,meter,nav,output," +
    "progress,section,time,video").split(',');
  for (var i = 0; i < e.length; i++) {
    document.createElement(e[i]);
  }
</script>
<![endif]-->
<!--[if IE 7]>    
        <link href="css/styleie7.css" rel="stylesheet" >
<![endif]-->     

        
        <script type="text/javascript" src="js/jquery-1.5.2.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.11.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.infieldlabel.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/jquery.text-overflow.min.js"></script>
 <!--[if lte IE 7]>
        <script type="text/javascript">
  			isRunningIE6OrBelow = true;
		</script>        
<![endif]-->


    </head>
    <body >
       <div id="wrapper">
            <div id="header">
                <div id="logreg">
                    <div class="logregItm">Registrieren</div>
                    <div class="logregItm">
                        <div id="loginBtn">Anmelden<span class="selectDropdown">▼</span></div>
                        <div id="loginPanel" class="overlayPanel hiddenOptions">
                            <form action="./loggedin.jsp?j_security_check" id="signin" method="post">
                                <p>
                                    <label class="inlinelabel" for="j_username">Username</label>
                                    <input type="text" tabindex="3" name="j_username" value=""
                                           id="j_username">
                                </p>
                                <p>
                                    <label class="inlinelabel" for="j_password">Password</label>
                                    <input type="password" tabindex="4" name="j_password" value=""
                                           id="j_password">
                                </p>
                                <p >
                                    <input type="submit" tabindex="6" value="Sign in" id="signin">
                                    <input type="checkbox" tabindex="7" value="1" name="remember_me" id="remember">
                                    <label for="remember">Remember me</label>
                                </p>
                                <a  href="/this">Forgot your password?</a>
                                <p > <a href="#" title="If you remember your password, try logging in with your email" id="forgot_username_link">Forgot your username?</a> </p>
                            </form>
                        </div>
                    </div>               
                </div>
            </div>
            </div>
            <div id="breadcrump">
                Home ›
            </div>
            <div id="container" >
                <div id="side-a">
                    <div id="price" class="inputForms overlayParent">
                        <label class="inputFormLabels ">Anzahl</label><span class="selectDropdown">▼</span>
                        <div id="timechooser" class="dropdownPanel" >
                            <noscript><select id="nS_timechooserList">
                                <optgroup>
                                    <option>Triebe</option>
                                    <option>Stengel</option>
                                    <option selected="selected">Individuen</option>
                                    <option>blühnende Individuen</option>
                                </optgroup>
                            </select>
                            </noscript>
                            <input id="tcL_selectValue" type="hidden" value="tcL_3"/>
                            <button id="tcL_button" class="button" tabindex="1"><span id="tcL_btn_label">per week</span><span class="selectDropdown">▼</span></button>
                            <ul id="timechooserList" class="overlayPanel hiddenOptions">
                                <li ><label id="tcL_1" >Triebe</label><span class="checkedListItem">✓</span></li>
                                <li ><label id="tcL_2" >Stengel</label><span class="checkedListItem">✓</span></li>
                                <li ><label id="tcL_3" >Individuen</label><span class="checkedListItem selected">✓</span></li>
                                <li ><label id="tcL_4" >blühnende Individuen</label><span class="checkedListItem">✓</span></li>
                            </ul>
                        </div>
                        <p >
                            <input type="text" id="minAmount" value=""  size="3" maxlength="6" /> -
                            <input type="text" id="maxAmount" value="" size="3" maxlength="6" />
                        </p>
                        <div class="hitCounter">580</div> 
                        <div id="slider-range" class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all">
                            <div class="ui-slider-range ui-widget-header" ></div>
                            <a id="rangeminDrag" tabindex="2" draggable="true" title="Minimum - drag around" class="ui-slider-handle ui-state-default ui-corner-all" style="left: 23.4%;"></a>
                            <a id="rangemaxDrag" tabindex="3" draggable="true" title="Maximum - drag around" class="ui-slider-handle ui-state-default ui-corner-all" style="left: 60%;"></a>
                        </div>



                    </div>

                    <div id="where" class="inputForms overlayParent" >
                        <label class="inputFormLabels">Location</label><span class="selectDropdown">▼</span>
                        <input type="hidden" id="fromWhoOnline" value="0" name="where" />
                    </div>
                    <div id="what" class="inputForms overlayParent" >
                        <label class="inputFormLabels">What</label><span class="selectDropdown">▼</span><br/>
                        <label class="inlinelabel" for="whatInput">Type here</label>
                        <input type="text" id="whatInput" name="what" value=""/><span>?</span><span>go</span>
                        <div  id="whatSearchAutocomplete" class="hiddenOptions">
                            <h3>Popular suggestions</h3>
                            <div>
                                <h3>Artists</h3>
                                <ul>
                                    <li >
                                        <a href="/music/Rihanna?ac=ri" title="Rihanna" class="artistItem">
                                            <img  src="http://userserve-ak.last.fm/serve/34s/51511879.jpg"> 
                                            <strong >Rihanna</strong>
                                        </a>
                                    </li>
                                    <li >
                                        <a href="/music/Rise%2520Against?ac=ri" title="Rise Against" class="artistItem">
                                            <img  src="http://userserve-ak.last.fm/serve/34s/8698619.jpg">
                                            <strong >Rise Against</strong>
                                        </a>
                                    </li>
                                    <li >
                                        <a href="/music/Damien%2520Rice?ac=ri" title="Damien Rice" class="artistItem">
                                            <img  src="http://userserve-ak.last.fm/serve/34s/3370426.jpg">
                                            <strong >Damien Rice</strong></a>
                                    </li>
                                    <li class="item selected">
                                        <a href="/music/Flo%2520Rida?ac=ri" title="Flo Rida" class="artistItem">
                                            <img  src="http://userserve-ak.last.fm/serve/34s/52067183.jpg">
                                            <strong >Flo Rida</strong>
                                        </a>
                                    </li>
                                    <li ><a href="/music/Rick%2520Ross?ac=ri" title="Rick Ross" class="artistItem">
                                            <img  src="http://userserve-ak.last.fm/serve/34s/48912113.jpg">
                                            <strong >Rick Ross</strong>
                                        </a>
                                    </li>
                                    <li ><a href="/music/Rilo%2520Kiley?ac=ri" title="Rilo Kiley" class="artistItem">
                                            <img  src="http://userserve-ak.last.fm/serve/34s/2755922.jpg">
                                            <strong >Rilo Kiley</strong>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div>
                                <h3>Albums</h3>
                                <ul>
                                    <li >
                                        <a href="/music/Rihanna/Good%2520Girl%2520Gone%2520Bad?ac=ri" title="Good Girl Gone Bad - Rihanna" >
                                                <img src="http://userserve-ak.last.fm/serve/34s/51010029.jpg">
                                            <strong>Good Girl Gone Bad</strong>
                                            Rihanna
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div>
                                <h3 >Tags</h3>
                                   <ul>
                                        <li >
                                            <a href="/tag/rock?ac=ro" title="rock" >
                                                <img  src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >rock</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/tag/alternative%2520rock?ac=ro" title="alternative rock" >
                                                <img  src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >alternative rock</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/tag/classic%2520rock?ac=ro" title="classic rock" >
                                                <img src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >classic rock</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/tag/indie%2520rock?ac=ro" title="indie rock" >
                                                <img  src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >indie rock</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/tag/hard%2520rock?ac=ro" title="hard rock" >
                                                <img  src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >hard rock</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/tag/punk%2520rock?ac=ro" title="punk rock" >
                                                <img src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >punk rock</strong>
                                            </a>
                                        </li><li ><a href="/tag/Progressive%2520rock?ac=ro" title="Progressive rock" >
                                                <img  src="http://cdn.last.fm/flatness/icons/activity/tagged.png">
                                                <strong >Progressive rock</strong>
                                            </a>
                                        </li>
                                    </ul>
                            </div>
                            <div>
                                <h3 class="label">Labels</h3>
                               
                                    <ul>
                                        <li >
                                            <a href="/label/Rhino?ac=rh" title="Rhino" >
                                                <img  src="http://userserve-ak.last.fm/serve/34s/3859158.jpg">
                                                <strong>Rhino</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/label/Rhino%2520%252F%2520Wea?ac=rh" title="Rhino / Wea" >
                                                <img  src="http://userserve-ak.last.fm/serve/34s/33644465.jpg">
                                                <strong>Rhino / Wea</strong>
                                            </a>
                                        </li>
                                        <li >
                                            <a href="/label/Rhino%252FWarner%2520Bros.?ac=rh" title="Rhino/Warner Bros." >
                                                <img src="http://userserve-ak.last.fm/serve/34s/15620041.jpg">
                                                <strong>Rhino/Warner Bros.</strong>
                                            </a>
                                        </li>
                                    </ul>
                            </div>
                            <div><ul>
                                            <li >
                                                <a href="http://www.last.fm/search?q=ri&amp;from=ac">
                                                    <span >Search for ‘ri’</span>
                                                </a>
                                            </li>
                                        </ul>
                            </div>
                        </div>
                    </div>
                    <div id="when" class="inputForms overlayParent" >
                        <label class="inputFormLabels">When</label><span class="selectDropdown">▼</span>
                        <input type="date" id="when" value="0" name="when1" />
                        <input type="date" id="when" value="0" name="when2" />
                    </div>
                    <div id="more" class="inputForms overlayParent" >
                        <label class="inputFormLabels">Location</label><span class="selectDropdown">▼</span>
                        <select name="top5" >
                            <option label="tester">Heino</option>
                            <option>Michael Jackson</option>
                            <option>Tom Waits</option>
                            <option>Nina Hagen</option>
                            <option>Marianne Rosenberg</option>
                        </select>
                    </div>

                </div>

                <div id="content">
                <ol id="searchItems">
                     <li class="mainitemlist">
                    <div>    <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                        <div class="il-txtbox"><h2 ><a href="/anzeigen/s-anzeige/kaffeeservice-23-tlg-henneberg/32679302" class="c-a-adtble-dscr ad-detail" >Kaffeeservice 23 tlg. - Henneberg</a></h2>
                            <p>Biete ein <sub>23</sub> tlg. <kbd>Kaffeeservice</kbd>,
                                            Henneberg/Echt Kobalt, 1777 Porzellan, 
                                            Made in <kbd>ghhhe</kbd>GDR, 1 Tasse + ...</p>
                        </div>
                        <div class="il-cardbox">
                            <img alt="location" src="images/carddummy.png" class="card-imgbox">
                    </div>    </div>
                    </li>
                    
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist">
                        <div class="il-imgbox">
                          <img alt="Kaffeeservice 23 tlg. - Henneberg 04315 Ost Vorschau" src="http://img1.classistatic.com/cps/bln/110719/962r5/03476l1_21.jpeg" class="img-imgbox">
                        </div>
                    </li>
                    <li class="mainitemlist"></li>
                    <li class="mainitemlist"></li>
                    <li class="mainitemlist"></li>
                    <li class="mainitemlist"></li>
                </ol>
               </div> <div id="side-b">
			SIDE B
                </div>
            </div>
            <div id="footer">
                <div id="footerframed">
                    <div class="footColm">
                        <h6>Über uns</h6>
                        <ul>
                            <li>Impressum</li>
                            <li>Impressum</li>
                            <li>Unsere AGB's</li>
                            <li>Wer wir sind</li>
                            <li>Unser Manifest</li>
                        </ul>
                    </div>
                    <div class="footColm">
                        <h6>Über uns</h6>
                        <ul>
                            <li>Impressum</li>
                            <li>Impressum</li>
                            <li>Unsere AGB's</li>
                            <li>Wer wir sind</li>
                            <li>Unser Manifest</li>
                        </ul>
                    </div>
                    <div class="footColm">
                        <h6>Über uns</h6>
                        <ul>
                            <li>Impressum</li>
                            <li>Impressum</li>
                            <li>Unsere AGB's</li>
                            <li>Wer wir sind</li>
                            <li>Unser Manifest</li>
                        </ul>
                    </div>
                    <div class="footColm">
                        <h6>Hilfe</h6>
                        <ul>
                            <li>FAQ's</li>
                            <li>Tutorials</li>
                            <li>Direkte Hilfe</li>
                            <li>Ich will mieten</li>
                            <li>Ich will vermieten</li>
                        </ul>
                    </div>
                    <div class="footColm">
                        <h6>Entwicklung</h6>
                        <ul>
                            <li>Unsere API</li>
                            <li>Entwickler AGB</li>
                            <li>Externe Software</li>
                            <li>Mobile Versionen</li>
                        </ul>
                    </div>
                    <div class="footColm">
                        <h6>Sicherheit</h6>
                        <ul>
                            <li>Vorsorge</li>
                            <li>etc.</li>
                            <li>etc.</li>
                            <li>etc.</li>
                            <li>etc.</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        ✓⊗∧∨√♥✉✔✔✓✎✖✕✗✘✩✬✪✿❤‹›▲△▴▵▼▽▾▿☑☐☒☐↵↻☆✩★⍟✭✮✯✰✸❂✆☂☀☁☎
    </body>
</html>