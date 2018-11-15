package org.usfirst.frc.team1339.robot.chad;

public class Chad {
	/*
	 *                    .:;;:''''+##+++++#######@##########+###################++#++++################+###++###+##+'######+##+++,#;::.                                                                       
                `.:'';:'++''###+''+#+'++#+#+#++##+########################'##++++##+#############++#########++''+####+##+#'+##+.,;`                                                                     
               `:;;';;'++''+#+++++###++++++++++++++##########################+##+##+##########@+##++#@+######+'''+#######+#####;,;:.                                                                    
               ::;+'''+'''+++++##+###+++#++++++++++######+###################+####++##########@#'###+#@+#++++#'';'+########+'##',.:,.                                                                   
              `;;';;'''''++++####+###+++++'++++++++#####+###################++####+#####+########'+#++##+++++###+';#########@###+',.,.                                                                  
             .:;;';+++'''''++####+#####++'+++++++#######+#########################+#+############+'+#+###++##++##+';+#######@####';:;;,                                                                 
           .;;;'';+++''+'+++++##+#+++++'''++++++++#+#++###########################+###############++#+####+###+###+''''+###@#######;+;'`                                                                
          `;;;;':'+++''+++++++##+++';';''''''+++####++###################################+#+#######'########+##+###+'';+#+#+########+';:,                                                               
         `;;;:+';+'+++'++#++++++';;;:;';;''+''+++###+######################################++#############++++##+++#+'+'+++@@###+'###++',,                                                              
        .:;;::'''+++#+++#++++';;;::::;:;;;''''+++++++#################################+@####+############+++++++++++#'+;''+##@##+'####++;;.                                                             
       .::;;::''''++#+''+++++':;:::::::';;;'+'++++++######################################################++++'++'+##+';'++##+#+++####+++;:                                                             
       .:;::'';+''+++++'''++';::,,::,,:';;''++++#++#######################################################+##++++'++#++';;';++#++#####+##',,                                                            
      `::;+'+#++''++++++'++';:,,.,::,::;;;''+++##++#######################################################+##+++'';;+++';;;;'++++#######++:;,                                                           
      ,:,;;+'+##+++#+++++'++:,....,:::;;;;''+++#++#########################################################++++''';;'';++:;;;++++##+#+##++';'                                                           
     `',,;'#''+++'''++++';:':,.``.,,::,:''''+++#+###############################@##########################+++++;;'::'';':::;''++##+#;#++#+;;;`                                                         
     .::,''+''+++''+'+''';:::.,.``.,,.:::'++++##################+###############@@#############+############+++'';;;,',,::,,,:;'++#'';#++#+;:;;,                                                        
    `::;:+'''+++#++''+''':::,...``....,::;+++################################################################+++':,:,:.,,,...,:'++#++'#++##:;;:'.                                                       
    :::;;'+#;'#++++''''::,,,,.`.```.....:;'+++##############+####+###########################################+++';:,,....,....,;'+##++###+#:;';:';`                                                     
  `::::''+++++'''+'''';::,,.`...```...,,,;;+++##################+###########################################++++'::,,.....``...:;+##+++##+'''';;'                                                       
  .;:;;+'+++++++''''';:,,,..````````..,,::;+++##########################################+###################+++';::,,.....```...:'+#+###'#;'''::+`                                                      
 ,:;;;:+''++'++++';;':,,..````````````..,:;++++#+#######################################++##+++#############+++;;;;:,:....````..,:+#++#+'#'#'''',;                                                      
,::;;;:+;'+++++++;;;;,...`````````````....;++++#+++##+++#+#############################+++++++++####++++###++++:;:::::,..```````.,''++++'##+'''';'                                                      
:;;;;';''''+'++++;;;:,..`````````````````.::''+++++++++##+++##########################+++++'''++++#+++++++#+'++::::::,...```````..,'++#++##++'''';`                                                     
;;;;';;'++''+'++'::::,,.`````````````````.:;':';'+++''+#+++##++#####################++++'''''''+++++++'++#+''+'::::,,....````````.,;++#+++++''';'''.                                                    
;;;:'';':;+'+''''::,,..``````````````````..;:,,:'+++''++++++###################+###+'+'''';'''''+++++''++#++'+;:::,,......```````..:;###++':'''';;;;`                                                   
:;;;+++;''+'+''';:,.,.````````````````````.:.,,,;';''''++++++#####+#+++###########+'+'''';;;'''''++++''++++''';,,,,,......````````.,:+##+'';;;:';,'';                                                   
;;::'++,'''''';;;,...`````````````````````.....,,:::;;'''+'++######++++####+#####+''';;;';;;'';'''++'''++++;;;:,,.........`````````.:+###';';;:+,:;;:                                                   
;;:;'++,'''''';;:,..`````````````````````````...`,.,,:;;;'''####+++++++++##+##+++''';:;;;::;;;;'''+';;++++';;:,,,............``````.,'###'';';:';:;;                                                    
,':';'';''''';;:,,````````````````````````````````....::::;'+##++++++'+++#+++++''''':::;;::;;;;';+''';'++';;;:,,,,...........``````..'+##+;';';;',;;                                                    
:';;''':''''';;:,.`````````````````````````````````..`.,,,,;+###+++++'+++#'+++';;;';:::::::;:;;';'''''''+':::,,,.,..............``...:'###:+;;;';:,.                                                    
;';'''':'''''';,..`````````````````````````````````````....:;+##''++++'+++++'';;;;:::::::::::;';;';'''''';;:,,,,,,..............``...:'+##;';;;;::,`                                                    
:';'''+;;''';;;,.````````````````````````````````````````..,,'+#'''++''++#+;;;;;;;:,:,,:,,,::;;;;''';;;'';;:,,,,,,...................,:+##''';;;;:,.                                                    
,:;'+''''';'';;:.``````````````````````````````````````````..';#'''''''++#;:;:;;::,,,,,,,,,,:::;;;;;;';;;::,,,,,,,,..................,:'+##+'';;';::                                                    
.:;;++''''''';::.``````````````````````````````     ````````.:,';:::;;;'++;::::::,,,,,,,,,,,,:::;:;::;:::::,,,,,,,,...................:;++##+';;:,;:                                                    
.,;:'+';''';';:,.``````````````````````````````      ````````......,,,::;':::,,,,,,,,,,,,,,,,,,::::::::::::,,,,,,,,,,................,,;+####':;;,:,`                                                   
,,;;+'''+';;'';,.``````````````````````````````      ``````````````...,,:;,,,,,:,...,,.......,,,,,,,,,,,:,,,,,,,,,,,,,................,:'+##+';;:;,,,                                                   
,,;'''+;''';'';,.``````````````````````````          ```````````````.....,,,,,,,,............,,,,,,,,,,,,,,,,,,,,,,,,,,................,;+##+''''''::                                                   
.,;;'++''+;;'';,.``````````````````````````          ```````````````............................,,,,,,,,,,,,,,,,,,,,,,,,...............,:'+++:'''';,:`                                                  
.,;';'+';';;'';,.````````````````````````````       ````````````````...........................,,,,,,,,,,,,,,,,,,,,,,,,,..,.............,;'++';;;'':;                                                   
,:,';'+'''';''::.``````````````````````````````   ```````````````.............................,,,,,,,,,,,,,,,,,,,,,,,,,,................,;''++''':';;                                                   
:;;;:;+''''''';:``````````````````````````````` `````````````````..............................,,,,,,,,,,,,,,,,,,,,,,,,,,,..............,::''++''';:,.                                                  
,;;';''''''';;;,`````````````````````````````````````````````.....................................,,,,,,,,,,,,,,,,,,,,,,,,,,,............,:''++'';;;;;                                                  
,:;;;'+'';''';;,.````````````````````````````````````````````...................................,,,,,,,,,,,,,,,,,,,,,,,,,,,,,............,:;''++''::::                                                  
:;;;;;''+;''';:,````````````````````````````````````````````....................................,,,,,,,,,,,,,,,,,,,,,,,,,,,,..............:;''++''''.`                                                  
,;;;;;+'+;''';:,.````````````````````````````````````````````...................................,,,,,,,,...,,,,,,,,,,,,,,,,,..............,;''++';'';`                                                  
:;;;;;''+'''';:,.`````````````````````````````````````````````...............................................,,,,,,,,,,,,,,,,,,,,..........:;'++'';;',                                                  
:;;''';''+'''::,.``````````````````````````````````````````````..................................,,..........,,,,,,,,,,,,,,,,,,,,,.........,;''+++';:`                                                  
,;';'''''++''::,.```````````````````````````````````````````````.................................,,...........,,,,,,,,,,,,,,,,,,,,,........,;:''+'+',                                                   
::;;++;'+++''::..```    ```````````````````````````````````````````````....``................,,,,,,.............,,,,,,,,..,,,,,,,,,,.,.....,::''+'++,                                                   
;:;'++;'+''';:,,.```      `````````````````````````````````````````````......................,,,,,,,............,,,,,,,,..,,,,,,,,,,.,,....,::;'++++,                                                   
::;'+'''';'';:,,.`` ` ``` `````````````````````````````````````````..........................,,,,,,.............,,,,,,,,,,,,,,,,,,,,,......,:::'+#++:                                                   
,:;'+'''':;;;::..``````   `````````````````````````````````````````.........................,,,,,,,.............,,,,,,,,,,,,,,,,,,,,,.......,,:;+#++:                                                   
::;'''';'';;;::..``````   ```````````````````````````````````````..`.......................,,,,,,,..............,,,,,,,,,,,,,,,,,,,,,........,,;++++'                                                   
;;:;''';;';;::,,.``````   ``````````````````````````````````````...`.......................,,,,,,.......,,....,,,,,,,,,,,,,,,.,,,,,,.........,,:'+#+'                                                   
:::'''';;;;;::,,.``````   `````````````````````````````````````..........................,,,,,,,,.........,,,,,,,,,,,,,,,,,,....,,,...........,:'+++;                                                   
;,;'';;;;:;;:,,,.``````   ````````````````````````````````................................,,,,,,,.,....,,,,,,,,,,,,,,,,,,,,,...................:'++#+```````                                            
',;';;;;;:;;:,,..`````` ``````````````````````````````````..............................,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,..................:;'##+.....```                                           
',;;';;;;,:;,,,...````` ``````````````````````````````````.............................,,,,,,,,,,,,,,,,,,,,,,,,,:::,::,,,,::,,,,,,....,,........:+#++,......                                            
.,;;;:';:,:,,.,..`````````````````````````````````````````............................,,,,,,,,,,,,,,,,,,,,,,,,,::::::::::::;:;;:;;;,,,,,........:'+++'.....,                                            
':;;::';;,:.,.,..`````````````````````````````````````````............................,,,,,,,,,,,,,,,,,,,,,,,:::::::::;;';;'''''':;;;::,,.......:'++++,....`                                            
+;;;:'';:,,.,,,..`````````````````````````````````````````........................,,,,,,,,:,,:,,,,,,,,,,,::::::;;;''''+'+''+++++'++'';;:,.......:'+##+;,..                                              
+;:;:;'::,,......`````` ````````````````````````````````.......................,.,,,,,,,,:::::,,,,,,::::,:::::;;''+++++++++++###+'+++;';:,......,;+##+,,..                                              
+:;;:;;::,,.....``  `   `````````````````````````...............................,,,,,,,,,::::::::,::::::::;;;;'''++##############+++++'';:....``.;'++;:,,`                                              
#;;:;::::,,....``      ````````````````````.....,.,.............................,,,,,,,::::::::::::::::::;;''++################++++++'''::,....`.'+++':,.                                               
#;;:'::;:,,,..``       ````````````````..,:,,,,,;:,,,,,,.,,,,,,,,,...........,,,,,,,,,:::::::;;;:::::;;';''+########@##++++++++'''''+++';;;,...``,'+++:,.                                               
#+:'';::::,,..`     `  ```````````````.:,,,:;;;;;;;;;;;;:;'';;:::,,........,,,,,,,,:::::::::;;;;;:::;;;''+###@@@####+#+++'++''''';;;;:'';,,,...``,'++':,.                                               
#+''';;;::,,.``     `   `````````.`.,:;;''++''';'++++++++++++';;;;::,,,,,,,,,,,,,,:::::::;;;;;;;;;;'''''+######+#++++++''+'';'';;;;;::;;:,.,...``.:++;,,.                                               
#++'';;::::..``         `````````..,;:;'+++++'++++############++;;;;:,,:,,,,,,,,,::;;;;;;;;;;;;;''''++++#####+++##++'+'''''';;;;;;;:::::;:,,...```:'+',.`                                               
+#+'';;;'::..``         ``````````.,;;;'++++++###################+'';::';;:::,,,::;;;;;;;;;;;;''''+++++####++++#+++++'+''''''''';;;::::::,,,...```,+++,.`                                               
..;':'+';;:,.``     `  ```````````.,;'+++++++'+++++++'+++++#######+++'+'+'';;::,:;;;;;;;;;;;;'''+++++++++++++++#++++++++'+++'''''';;::,::,,,......,'+':.`                                               
`..,''''';;,.``   `     ````````...,:::;';;;;;;';;;:;;;''''''''++++'+'+++'''';:::;;;;;;;;'''''''++++++++########@@#@@@@@@@@@@###++';;:,,::,,.......;+;;.`                                               
``.,;';''';:.``     `   ```````..,::,,:,;:,,,:;;::::;;;;;'''''''''''+'++++++''';;;;;;;;;;;'''''+++++++#########@@@@@@@@@@@@#@@@#@##+':,,::,,.......:+':,`                                               
``..:'''''';,.`      `  ``````.:::::,,....,,,,,:,,,::::;;;''''''''';'''''''''';;;;;;::;;;'';'''++++###########@@@@@@@@@@@@###########':,::,,.......:++;,`                                               
``..,;';'';;,`      `     ```.,,,,,............,,,,::::;;;;'''''+''''''''''';;;';;;;::::;;''''++++############@@@@@@@@@@@##+#########+':::::,......,++;,`                                               
``...,:';';:.``           ```......````........,,,,,:,:'''''''+++++++++++''';;:,,,:::::::;;;;''+++########@@@##@@@@@@@@@#++######'++''';:,,.........++;,`                                               
```....;;;;;.``    `   `` ```....``````.......,,:::;''++######+++#++++++++'';:,,,,,,,::::;;;;'''+#######@@@#####@@@@@@@#++#++#++;;:,;';::,,,........++;,`                                               
````...`:';:,```          ````..````````....,::;;'+##@@@@@#@########++++++++;:,,...,,,,,:::::;;+++####@@@@#@###++++++++++++';;;;;:,,,;;;;;:,,.......++;,                                                
`````...,;;;:.``        ````````````````..,,:++#@@@@@@@@@@@@@##########+#++';:,,.....,,,:::::;;+++#++########++++'+;''';;;;;:::::,,:,,,,,:,.........'';,                                                
```````.,'';:.`` `     ````````````````..:;+#@@@@@@@@@@@@@@############+++'';,,,.......,,,,:::;++++++++++#+++'';;;;;::,::;::::::;:,,,,,,............'',.                                                
````````.;+':,.`       ````````````````.:+##@####@########@++##########+';;:,,,,...``....,,,::;'+++##+++++'''';;;;;;::::;;;;;;'';;;:,,,,,,,.........'+,.                                                
```......:';:,``` ```  ```````````  `.,++#@@##+';##########+++########+';;:,.......```....,,,:;;'++++++++'''';;;;;;;;''''''''''''';;;;,...,,,.......;+:.`                                               
``...,:;'';;,,.`        `````....````,+######++';'+#######+'++++++++''+''':,,.....`````..,,,,::;'''++++++'''';;;;;;;;''''''''''''''';;;:,,...,......;+::                                                
``..,:;;''';:..`        `````.....`.,'++';::;;++''++++++'++'+''''++'''''';:,......`.```...,,,::;;'''''+'''''''';;;;;''';;'''''''''';::::::,.........;':`                                                
``..,::;'''';..`    `   `````......,:;;:,,..,,.,,,:';+'''';;;'''''''''''';,.......`.```...,,,:;;;;'';;'''''''''''''''''''''''''';;;::,:,,,,,,......,;+,                                                 
 `.,,::;'''''..` `  ` ```````````...,,,.........,..,,',:;:;;'''''''''''';,.........```.....,,;:;;;;';;;;;;;''''''+''+++++'''';::,,,,,,,,,,,,,,.....,;`                                                  
``.,,:;'''';',.`       `````````.......``````........,,,:;;''';;;;;;;;;;;..........```....,,,:;;;;;;;;;;;;;;;;;;;;;;;';';;:::,,,,..,,,,,,,,,,,,....,'                                                   
``..,:;'''';;,.`  `     ````````......`............,,,:;;;'';;;;:;;;;;;;,.........````.....,,,::;;;;;;;;:;::::::::::::,:,,,..,.......,,,..,,,,.....,;                                                   
 ``.,:;''';;::,.`   ` ` ``````````````.......,,::::;;''';;;::::;::;;;;;,...........````....,,,:::::;;::::::::,:,,,,,,,,,.............,,,,,,,,......:,                                                   
 ``.,:;''';:,,,.`   `    ``````````....``...:::;;;;;;::,,::::;;;;;;;;::,.......`...````....,,:::::::::::::::,,,,,,,,,...,............,,,,,,,.......;:                                                   
 ``..,;''';:.`,.`        `````````..```..,,:,,,,,,,::,,::::::;;;;;;;:,...`.....````````....,,,::::;::::::::,,,,,,,,,.,..,.........,,,,,,,,,,.......,,                                                   
 ```.,:;''':`.:..`    ``````````.````...,,,,,,:,:,:::::;;;;;';;;;;,,,..`..`````````````....,,,::::::::::::,,,,,,,,,,,,.......,,,,,,,,,,,,,,,.......,                                                    
  ```,,:;'':``:..`        ``````````````.......,,,::::;;;;;;;:,........````````````````....,,,:::::::::,,,:,:,,,,,,,,,,,,,...,,,,,,,,,,,,,,,,,,,...,                                                    
   ``.,:;''',`,,.``       ````````````````..........,,....,...........``````````````````....,,,:::::::,,,::::::,,,,,,,,,,,.,,,,,,,,,,,,,,,,,,,,,...,                                                    
   ````.,,:,.,::.``       ```````````````..`````......................``````````````````....,,,:::::::::,::;;;;:::,,,,,,,,,,,,,,,,,:::::::,,,,,,,...                                                    
   ```...`````,:..`      ````````````````..```````..```.`````.....`..````````````````````....,,::::::::::::;;''';;:::,,,,,,,,,,,,,:::::::::::,,,,...                                                    
    ```...````,:,.`      ````````````````````````..``````````...........`````````````````.....,::::::::::::::'+++';:;::::,,,,:,,::::::::::::::,,,,.,`                                                   
     ``````````::.``      ````````````````````````````````........,,:,,.`````````````````....,,,,,:::::::::::;+#++'';;;:::::::::::::;;:;;;;:::::,,..`                                                   
        ```````::.```     ```````````````````````````...........,,;;':..````````````````....,.,,,,,,::::::,,::+##++'';;;::::::::::::::;;;;;;;;;::,,.`                                                   
       `    ``,,,,.``     ````````````````````````............,,:;'':..``````````````````.....,,,,,,,::::,,,,:'##++++'';;;;;;:::;;;;;;;;;;;;;;;;:::.`                                                   
            `..`.,.```    ``````````````````````..........,,,,:;;+++,.``..````````````````....,,,,,,,::::,,,,:;#++++++'''';;;;;;;;;;;;;;;;;;;'';::,.`                                                   
        `     ``.,..``    ````````.``````````............,,::::''+++,`````````````````````....,,,,,,,:::,,,,::;++++++++'''';'';;;;;;;';;;;;;''';:::,,                                                   
         `     `.,.````   ```````...``..`````..........,,,,::;'''+++.`````````````````````....,,,,:,,:::,,,:::;+++++++++''''''';;;;''';;;;;;''';::::`                                                   
         ``     .,.````    ````````.................,,,,:;;;;'''''++.`````````````````````...,,,,,,::::::,::::'+++++++++++'''''''';'';;;;;;;'';;::::,                                                   
           ``   .,,.```   ````.````...............,,,,:::;;;''''''++.`````````````````````..,,,,,:,::::::::::;+++++++++++++++''''''''';;;;;;;';;;;;;;                                                   
            `   `:,.```   `````````.............,,,,,:::;;;'''+++''+,.```````````````````...,,,,,:,,,:::::::;++++++++++++++++++'''''';;;;;;;;;;::;;::                                                   
                `.,.```   ````.`````.........,.,,,:::::;;;''++++'''''.....```````````````...,,,,:::::::::::;+#+++++++++++++++++++'''';;;::::';;::;;,`                                                   
             `  `..,```   ```..``````........,,,,,:::;;;'''+++'''''''',...``````````````....,,,,::::::::;;+#+++++++++#+##++++++++'''';;;;::;;';;::;:`                                                   
              ```..`,``   ```...`````......,,,,,,,::;;;'''+++'''''''';;:,..````````````.....,,,:::::::;;+####++++++###+#####++++++'';;;;;;;;;;;;:;':                                                    
                    ````   ``..,.`````....,,,,,:,::;;'''+++++''''';;;;;;;;;,....`````......,::::;;:;;''##############+######+###++''';;;;;;;'';;:;;:                                                    
                     ```   ``..,,````....,,,,,,:::;;''''++++''''''';;;;;;''+++,...`.......,,::;;;;;''#@@#########+###########++##+'';;;;;;;;'';;;;;`                                                    
                     ...`  ``..,,.```.....,,,,,::;;''++++++''''''';;''''''+'####',......,,,,::;;;;;#@@@######################++##+';;;;;;'''+;;;;';                                                     
                      .``  ```.............,,,::;;'''++++++'++''';;'+''''+++######':...,,:::;;''''###@@######################++##+;;;;;;;'''''';'''`                                                    
                      ```  ```........,....,,,::;''++++++++++'+'';'+'''''+++++######',,,:;;'''''+#@@@####+########+#####++###+++#+;;;;'';'''''';'''                                                     
                      ``` ````........,.....,,:;'+++++'+++'++'+''''+''''+++###########+';;'''''###@######+#++++++++#####++++#++##+';;;'''''++''''+,                                                     
                      `.` ````....,,........,,;''++++''''''+''+'++++'''''++###########@@@###############+++++++''++####++++######+'''+'''''++'''+;                                                      
                       ,. ``.....,:,,,......,::'++#+';'''''++++++++++++++++#+###+################+#++#'+++++++++++##############++''+#+''++#+''++`                                                      
                       .,```.``.,:::,,......,::;'+++';;;'+++#+++++''+++++'++++##+++''+++###+++++++++++++++++++##################+''''+#++##++'+':                                                       
                         `````..,:::,,,,...,,,::;+#+;::;'+##++''';''++'''''++++++''''''+++++++++++++++++#+#######++++++#########+;'''+##+##+'+#+                                                        
                         ````..,,,;::,:,.,,,,,:;;+#+;:;;'++#+++'''''''''';;''''+'''''''++++++++#####+#####+++++++'''++++#######+'''+'+++##+++++;                                                        
                         ````...,;::,,::,,;;:,:;;;++'';;+##########++++''''''''+++'++++++++++#+########++'''+''''''''+++#######'++++++#++##+++'                                                         
                          ```,..,,:,,,::,,'';::::;'+++''+#+###+';++++++'''''++++++''''+++++'+#######+';'''''''''''''''++++++#++'+++++##+++++''                                                          
                            `.,..,::::::,;'';:::::;'+++++++#++';,,:'';;;::,,,:'+#+++'''''++++###+++;;;;'''''';;'';'';''''#++++'''+++++##+++++,                                                          
                            .,,..,:;;:;:,'++::::::,;'+'++++++';:,,,,,,::,,....,::;;'''''+'+''';'';;;;'''''';''''';'';;'''+++++''''+++###+++'+`                                                          
                           .':.,,,;;::;:::+';;;:,,,:;;++++++';;:,:,,,,,:,,:,,....,,,,::::;;::::::;;'''''';;;''''';'''''''++++++'''+++####+++'                                                           
                           '::,,::::::;:::;;;'';;::::;'+++++';:,,,,,,,,,,,,::::,,..,::::;;'';;;'''''''';''''''''';;;;''''+++++++''+++####+++                                                            
                          .',::.;,:::::::;;:;'+;'::::;''++++';;,,,,,,,,,,,..,,::::::;;;;;;'''''''';;;''''''''''''';;;''''+++++++'+#######+#.                                                            
                          `'+',.;,:::,:::;;:;+'';:;;;;'''+++';:,,,,,,,,,,,,..,,,,,,:::;;;;;;;'''';;';'''+'+'+''';;;;''''''++++++++#######+;                                                             
                           `+':'::,,;,,::;;;'+'';;;:;;;'''+++':,,,,..,,,,,,,,,,,,,,,::;;:;;;''''''+++++++#'''''';;;'''''+'+++++++########;                                                              
                            ,'+;:';:::,:;;'''+;';;;;;;;'';++++:,.....,,,,,,,,,,,:::::;;''''''++++++++##++++'''';';'''+++++++++++#######+'                                                               
                             '+''++;;;::;;':;'''''':;;;;;'++'';:,....,,,,,,,:::;;;;''''+++#++++++###+++#+++++';';''''++++++++++########+`                                                               
                             `++''';;::;;';;;;'';'':;;;;:;'';;;;:,..,,,,,,,::';'''++++++++###########+#++++++''';'++##++''+++###@@#####.                                                                
                              `'+;'++:,,;;'';''++'+';';'''+';;';;,,,,,,,,,,::;;'''+++#+++############+++++++++++''+####++##+####@@####+                                                                 
                               .:;;;+'';';;;+++++++++'';;;'';;;;:;:,,,,..,,:::;'+'''+################+++'''''+++++++####+########@#####                                                                 
                                `;;'''#+;''+++++##++++'';;;';';::;::,,,.,,,:,::;;;''+++############++++'''''''''+++++#################@                                                                 
                                 ,::'''++';++'##+##+++'+';;;''';,;;::,,.,...,,:::::''++#########+++++''''''''++++++++#####@############                                                                 
                                 `,;;'++++''''++##++#++'''';;';;::'';,,.,..,,,,,,,:;;;'+'+++++++'''+'''''''''++++++++#################.                                                                 
                                ```,+'++##+''''+++####++'+'++';;;''';:,,,,..,,,,,,::::;'';;;:'';;'''''''''++++++##++##+######@######'#                                                                  
                                  `.';''++'++''''+####+#+++++''';;;';;:,,,,,,,,,,,,:::;::::::::::;;;''''''++++######+##############@,:                                                                  
                                  ```,;+++'+#+'+'+#++#######++++';';;'':::::::,,,,,:::;::::,,:::;;;;;;'''+++++#####################',                                                                   
                                `````.:''+++++++'+++####+##+##'';;;;:;;;:;::,::::,:,::::::,,::::;;;;';;'++++++######+############@#,,                                                                   
                               ````````,''+#++++'++++#########++''''''::'';;;:::::::;;;,::::::::;';''''+++++#+####################,,,                                                                   
                           ````````````.,:+++'+++'''###########++++'';;+';;;;;;;;';;;:::::;';;:::;;;''++++++####################+;:,:                                                                   
                        `.+'```````````...'++''++';+##########+##++'''++';';''';::;::;:::;;;;;;;;;'+++++++++#+###############@##:::,,.                                                                  
                       `.:+`````````````...;;'++++++'+###########++++':;;'';';'';;:'';::,:;':;''''''+#+++####################@#':::,::..``                                                              
                      `.,::.```````````....,;''++#+++++###########+++'';'''';:;++++'';:::''';''''++++#++#+#################@@#+;:,::,'+:,,,,``                                                          
                    `..,,:;.````````````....,;'+++++##+#+##########+'';;''++;;;+++++''';:''++'''+++++#+#############@########+;::,,,.:;##;::::,.``                                                      
                  ``..,:::;,````````````...,,,:;'##################+#+''++;,+''''''+++''''+++'++++++++++######+#########@@##+;;::::,,;;''#+;:;'';:...`                                                  
              `....,,:::::;;.````````````....,,:;+'+++#########++#++++'++'::+'''+''+++++'++''''+++++++++#####+#####@###@@@##';;::::,,;,;''##';:;''';:,.`..``                                            
             `,,,:::::::::;;:.``````````......,,::;'++#############+'++#''''+'+''+++'++++'+'''+++++####+##########@#####@@+'';;:::,,,+::'+++''#';:;'';;:,.......`                                       
          ``.,;::;::::;;;;;;:,.`````````.....,,,,:::''+###+++#######+###+++++'+''++++'++++++++++#################@@#######'';;;::::,,#':;++#+:'''###+#+++;:,,,,,,..``                                   
         `.,::;;;;;::;;;;;;;';,.````````.......,.,::;''+############+###++#++++++++#+#++#+++#+##################@@@######+'';;::::,,.#+::+++#';'++''+''++#####';:,,,,.....`                             
     ``..,,;;;;';;;;;;;;;;;;;;;.`````````...,,....,;;;;;'+##########++#####+#++++++################@#######@@###@@@@@@#++'';;;::::,..+#;:'++++;''+'''''''''''';'+##+';::,,,.....                        
  ``...,,:;;'';;;;'';;;;;;;;;;',.````````....,,.,.,,:::::'+#@#######++++########++++#####################@#@@@@@@@@###+'''';;;;:::,...#+;;'+'#';''''''''''''''''''';;'+#####;::,...`.`                  
..,,,,,::;;''':;';'';'';;;;;;;';:.````````.......,,,,,,:;;''+##@########+++######+#+#####@#@@@@#@@###@@@##@@@@@@@@##++++''';;;:::,,...#+;:;+'++';''''''''''''''''''''''''';'++#####+';,.....`           
,,,,,,,::;;;;;;;''''';'''';;;;';;,`````````.......,,,,,,;:'''''###@@###+#++##############@#@@@@#@@@@@@@@##@@@@@@@##+++++''';;:::::,...;#';;++'#;;'''''''''''''''''''''''''''''';;;;;+#####+';,.......`  
,,,,:::;;;;;;:;'+''''''''';;';;'';,`````````......,,,,::::::''''+###########+############@###@@@@@@@@@@@@@@@@@@#+++''+''++';;:::::,...:#+;;'++#+''''''''''''''''''''''''''''''';'''';';;''';+######++;:,
,,,,::;;;;;;'#++';;'''''''';''';;':`````````.......,,,,,,:::'';'++++#@@@###+####@@#@@####@@##@@@@@@@@@@@@@@@#+''''++++''''';;;::,:,....#+';''++#''''''''''''''''''''''''''''''''''''''''''''';;';;;;;'++
,,:::;';+####+''';;'''''''''''''''',`````````...,,,,,,,,,,::;;;'''++++############@@#@##@@@@@#@@@@@@@@@@@@##++'''''++''++'';;::::,,....#'+;;'''#';'''''''''''''''''''''''''''''''''''''''''''''''''''';;
,::;+##';++'+'''''''''''''''';'''';;.`````````...,,,,,,,,,,:::;;;'''+'++#@#@###@@@@@@@@@@@@@@@@@@@@@@@@####'++'''+'''''''';;;;:::,,....#'+'''++++;++''''''''''''''''''''''''''''''''''''''''''''''''''';
:'##+'';;''++''''''';'''''''';'''';''.`````````....,,,,,,,,,:;;;;'''''''''''+##@@@#@@@@@@@@@@@@@@@@@#####+++'''''''''''+'';;;;:::,,...,#'''''++++;''''''''''''''''''''''''''''''''';''''''''''''''''''';
+#';''';''''''''''''''''++'''''''''';'.``.```.......,,,,,,::::;;;'';''''''''';'''+####@#@@####@#########++++'''''+'++'+''';;;;:::,,...:#''''''++#''+'''''''''''''''''''''''''''''''''''''''''''''''''';;
'''''''''''';;'''''';;;'++''''''''''''',`````........,,,,,,::::;;;;''''';;''''''''''''+++###############++''''''''''++'''';;;;:::,,...;#''''++''#'''''''''''''''''''''''''''''''''''''''''''''''''''''''
''''''''''''''''''''';'''++'''''';'''''';````..........,,,,:::::;;;''''';'''''';;;';;';''++++++++++###+++''''''''''''''''';';;:::,,...+''+'++++++''+++''''''''''''''''''''''''''''''''''''''''''''''''''
''''''''''''''''+''''''';+'''''''''''''+++.````........,,,,,,:::;;;;;';''''''''';;;;;;';'''''++++++++++++++'''''''''''''''';;;:::,,,.,++''+++++'#'''++''''''''''''''''''''''''''''''''''''''''''''''''''
''''''''''''''''+'''''''''''++'''''''++++'+:.```......,,,,,:::::::;;;;;;''''''';';;;;;;;;''';''''++++++++'''''''''''''''''';;::::,,,.;+++++'++++'''++'++'+'''''''''''''''''''''''++'''''''''''''''''''''
''''''''''''''''+''''''''''''+++'''''+'++++'+;.........,,.,,,:,:::::;;;;;;''''''''';;;';;;;;;'''''++++'++''''+++'++''+'''''';:::::,,:+++++++++++'''+++++'''''''''''''''''''''''''''''''''''''''''+''''''
'''''''''''''''''''''+''+'''''++++''''+++++++++'........,,,,,,::::::;;''';;'''''';;;;;;;;;;;'';;'''++++++'+++++'''''''''''';;;::,,:;+++#++++++++''++++++''+'''''''''''''''''''''''''''''''+++'''++''+'''
''''''''''''''''''''++'''''''''+''''''+++++++++++':,....,,,,,,,,::::;;;;;''''''';;;;;;;;;;;;;;;''''++++++++++++'''''''''''';;:::;;++++++#++++++++'++++++''++''''''''''''''''''''''''+''+'''+'''''''+++++
''''''''''''''''''+'++'''''''''''+++'+'++++++++#++++',:,,,,..,,,,,::::;;;;'''''''''';;;;;;;;;';''''+++++++++++'''''''''';;;;;::'''++###++++++++'''++++++++++'''''''''''''''''''''''+''''''''''''+'+''''+
'''''''''''''++''''''''''''''''''''+++'''+++++++#+#++++;:,,..,,,,,::::::;;;;;;;''''''''''''''''''''++++++'+'''''''''''';;;;;;;'+++####+++++++++'+++++++++++++''''''''''''''''''''''''+'''+'''++++++'''''
'''''''''''''''''''''''';'''''''''''++++'+++++++#####+####+':,:::,,,:::::;;;;;;;;;''''''''''''''+++++++++''''''''''''';;;;;:'++++######++++++++++++++++++++''+''+''''''''''''''''''''''''++++'+++++++'++
''''''''''''''''++''''''''''''''''''''+++++'+#+##########+#++#++';;::::::;;;;;;;;;;'';;;''''''''+++'+++++'+''''''''''''''''++++#######+++++#+++++++++++++++++++''+++''''''''''''+'''+'''''+++'++''++++++
'''''''''''''''''''''''+''''''''''''''''++++++++################++++++'';;;;;;;;;;''''''''''';';''''+++++'++++++++++++++#######+######++++##++++++++++++++++++++''''++++'''''''''''''''''''''+''''++++++
''''''''''''''''''''''''''''''''++''''+'++++++++++#########################+##+##+++#+++''''++++++++##+#++++#######################++++++#+++++++++++++++++++++++++++++'++''''''++''''''++++++++''++++++
;;'''''''''''''''''''''''''''''+''''''''++'++++++++++#################################################################@@@###########++++#+#+++++++++++++++++++++++++++++++++''''''+++++++''+++''''++++'+
'''''''''''''''''''''''''''''+'''+''''''+'+++++++++++++#########################################################@@#####@@#########++++#++++#+++++++++#+++++++++++++++++++++'''+''+++'++++++++++++++'''++
''''''''''''''''''''''''''''''''''''''''++'++++++++++++'++########################################@####@##@@@##@#################+++#####+++++++++++++#+++++++++++++++++++++++++'+'+'''++'+++++++++''+'+
'''''''''''''''''''''''''''''''''''''''''+''+++++++++++++++#+###################################@@@#####@@#####################+++###++##++++++++++++###++++++++++++++++++++++++'+++'''++'+'+''+''++++++
'''''''''''''''''''''''';''';''''''''''++++'+++++++++++#+++++++#+#############################################################+###++++#++++++++++++++###+++#+++++++++++++++++''++'++'''+''+'''''''+''''+
''''''''''''''''''''''''''''''''''''''''''+'''++++++++++++++++++++++####################@###############@@#@@##@###########+####++######+++++++++++++++++++++++++++++++++++++++++'+++''+++'++'+''+++++'+
''''''''''''''''''''''''''''''''''''''''''''''++++'+++++#++++##+++###++#++##############################################++####++######+##++++++++++++++++++++++++++++++++++++++''+++++++'+''+'+'''++++''
''''''''''''''''''''''';''''''''''''''''''+++''++++++++++###########################+######################################'+#######++++#++++++++'+++++++++++++++++++++++++++++'++'+'+++++''''''''+++''+
'''''''''''''''''''''''''''''''''''''''''++'+'++++++++++++++++###################################+###+++###############++##########+++++++++++++++++++++++++++++++++++++++++++'''++++'++++'''''''''++'''
'''''''''''''''''''''''''''''''''''''''++++++++++++++++++++++++++##########+#####################################################+++++++++++++++++++++++++'++++++'++++++++++++++++''+'+'''''+''+'++'+'''
''''''''''''''''''''''''''''''''''+++'++++++'+++++++++++++++++++#+++##++################++###########+########################++++++++++++++++++++++++'++++++++++++++'++++''++''+''''+'++'''''''''''''''
''''''''''''''''''''''''''''''''+'+++++++++'+++++++++++++++++++++++++++++###################################################++++++++++++++++++++++++'+''+++''+'''++''''''''+++++++'''''+'+'+''''+''''+''
'''''''''''''''''''''''''''''++'+++'+'++++++++++++++++++++++++++++++++++++#++######++####################################+#+++++++++++++++++++'+++++'++++++''+'''+++++''''''''''''''''+'''+'''++''''''''
;'''''''''''''''''''''''''''+++++++'++++++++++++++++++++++++++++++++++++++#+##+#+####+############################+##+++++++++++++++++++++++++++'++++++'+''+'+'+++'+'+''++''''''''''''''''''''''''''''''
'''''''''''''''''''''''''''''++++'++++++++++++++++++++++++++++++++++++++++++++++##++#######+###########+############++++++++++++++++++'++++'++++''+++++++++++'+++++'''''+''+'''''''+''''''''''''''''''''
'''''''''''''''''''''''''''+++++++++++++++++++++++++++++++++++++++++++++++++++++++++#+++##++++##+#######++#####+##+++++++++++++++++++++++++++'+'+++++''++'+''+''+++++'''''+'''''''''''''''''''''''''''''
''''''''''''''''''''''''''''''++++++++'++++++++++++++++++++++++++++++++++++++++++++#++++++++++++####++++++++#+##+++++++++++'++++++++++++++++++++'+++++'++++'++'+''+'+'''''''''''''''''''''''''''''''''''
''''''''''''''''''''''''''++'+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#+++++++#++++++++++++++++++++++++++++++++++++++++''++++'''''''''+'''++'+''''''''''''''''+'''''''''''
''''''''''''''''''''''''''++'''+'++++'+++++++++++'++++++++++++++++++++++++++++++++++++++++#++++++##++++++++++++++++++++++++++++++++++++++++++++++''+''''+'++'++'+'''+'''''''+'''''''''''''''''''''''''''
''''''''''''''''''''''+'''''''+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#+++++++++++++++++++++++++++++++++++++++++++'++++++++'++++'+'''+'''''''''''''''''''''''''''''''''
'''''''''''''''''''''''''''''''++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#+++++++++++++++++++++++++++++++++++++++'++++''++++++''+++'+''''''''+''''''''''''''''''''''''''
'''''''''''''''''''''''''''''++++++++++++++'+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++''''''+''++''''''''''''''''''''''''
''''''''''''''''''''''''''''''+'++++++++''++''''++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++''+++++'''''''+++''''+''''''''''''''''''''''''''''''
	 */
	
}