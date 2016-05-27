; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
AppName=BrewPlus
AppVerName=BrewPlus
AppPublisher=BrewPlus.blogspot.it
AppPublisherURL=http://BrewPlus.blogspot.it
AppSupportURL=http://BrewPlus.blogspot.it
AppUpdatesURL=http://BrewPlus.blogspot.it
DefaultDirName={pf}\BrewPlus
DefaultGroupName=BrewPlus
AllowNoIcons=yes
OutputBaseFilename=setup
Compression=lzma
SolidCompression=yes

[Languages]
Name: "italian"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked
Name: "quicklaunchicon"; Description: "{cm:CreateQuickLaunchIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\config\*"; DestDir: "{app}\config"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\mashes\*"; DestDir: "{app}\mashes"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\recipes\*"; DestDir: "{app}\recipes"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\Templates\*"; DestDir: "{app}\Templates"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\shopping\*"; DestDir: "{app}\shopping"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\BrewPlus.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\cache.xml"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\runner.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\run.bat"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\run.sh"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\DATI\SVILUPPO\JAVA\BrewPlus\PACKAGE\BrewPlus.exe"; DestDir: "{app}"; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\BrewPlus"; Filename: "{app}\BrewPlus.exe"; WorkingDir: "{app}"
Name: "{group}\{cm:UninstallProgram,BrewPlus}"; Filename: "{uninstallexe}"
Name: "{commondesktop}\BrewPlus"; Filename: "{app}\BrewPlus.exe"; Tasks: desktopicon
Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\BrewPlus"; Filename: "{app}\BrewPlus.exe"; Tasks: quicklaunchicon

[Run]
Filename: "{app}\BrewPlus.exe"; WorkingDir: "{app}";Description: "{cm:LaunchProgram,BrewPlus}"; Flags: nowait postinstall skipifsilent
