BEGIN TRANSACTION;
DROP TABLE IF EXISTS `typeOperateur`;
CREATE TABLE IF NOT EXISTS `typeOperateur` (
	`idTypeOp`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`type`	TEXT,
	`vitesse`	INTEGER,
	`armure`	INTEGER
);
INSERT INTO `typeOperateur` VALUES (1,'Attaquant',3,1);
INSERT INTO `typeOperateur` VALUES (2,'Attaquant',2,2);
INSERT INTO `typeOperateur` VALUES (3,'Attaquant',1,3);
INSERT INTO `typeOperateur` VALUES (4,'Défenseur',3,1);
INSERT INTO `typeOperateur` VALUES (5,'Défenseur',2,2);
INSERT INTO `typeOperateur` VALUES (6,'Défenseur',1,3);
DROP TABLE IF EXISTS `typeArme`;
CREATE TABLE IF NOT EXISTS `typeArme` (
	`idTypeArme`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomTypeArme`	TEXT
);
INSERT INTO `typeArme` VALUES (1,'Fusil d''assaut');
INSERT INTO `typeArme` VALUES (2,'DMR');
INSERT INTO `typeArme` VALUES (3,'LMG');
INSERT INTO `typeArme` VALUES (4,'Shield');
INSERT INTO `typeArme` VALUES (5,'Pistolet Mitrailleur');
INSERT INTO `typeArme` VALUES (6,'Pistolet');
INSERT INTO `typeArme` VALUES (7,'Mitraillette');
INSERT INTO `typeArme` VALUES (8,'Shotgun');
DROP TABLE IF EXISTS `typeAccessoire`;
CREATE TABLE IF NOT EXISTS `typeAccessoire` (
	`idTypeAccessoire`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomTypeAccessoire`	TEXT
);
INSERT INTO `typeAccessoire` VALUES (1,'Canons');
INSERT INTO `typeAccessoire` VALUES (2,'Viseurs');
INSERT INTO `typeAccessoire` VALUES (3,'Poignées');
INSERT INTO `typeAccessoire` VALUES (4,'Sous-Canon');
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
	`idRole`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomRole`	TEXT
);
INSERT INTO `role` VALUES (1,'Roamer');
INSERT INTO `role` VALUES (2,'Intel');
INSERT INTO `role` VALUES (4,'Aera Denial');
INSERT INTO `role` VALUES (5,'Utility');
INSERT INTO `role` VALUES (6,'Entry Denial');
INSERT INTO `role` VALUES (7,'Support');
INSERT INTO `role` VALUES (8,'Hard Breach');
INSERT INTO `role` VALUES (9,'Hard Breach Support');
INSERT INTO `role` VALUES (10,'Soft Breach');
INSERT INTO `role` VALUES (11,'Fraggers');
INSERT INTO `role` VALUES (13,'Situational');
INSERT INTO `role` VALUES (14,'Hghly Situational');
DROP TABLE IF EXISTS `operateur`;
CREATE TABLE IF NOT EXISTS `operateur` (
	`idOperateur`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nomOperateur`	TEXT,
	`nomCode`	TEXT,
	`bio`	TEXT,
	`ddn`	TEXT,
	`cheminIconeOp`	TEXT,
	`cheminImageOp`	TEXT,
	`idCapacite`	INTEGER,
	`idTypeOp`	INTEGER,
	`idRole`	INTEGER,
	`idCTU`	INTEGER,
	FOREIGN KEY(`idTypeOp`) REFERENCES `typeOperateur`(`idTypeOp`),
	FOREIGN KEY(`idRole`) REFERENCES `role`(`idRole`),
	FOREIGN KEY(`idCTU`) REFERENCES `ctu`(`idCTU`),
	FOREIGN KEY(`idCapacite`) REFERENCES `capacite`(`idCap`)
);
INSERT INTO `operateur` VALUES (1,'Seamus Cowden','Sledge','Seamus Cowden possède une âme de chef et une force physique impressionnante; il détient le record de vitesse et de force pour l''examen de qualification physique du SAS. Il préfère être l''homme de pointe lors des opérations, prêt à créer un chemin pour ses coéquipiers d''un coup de son marteau de démolition tactique, « Le Tronc ». ','1982/04/02',NULL,NULL,1,2,10,5);
INSERT INTO `operateur` VALUES (2,'Mike Baker','Thatcher','Né dans une famille de manutentionnaires, Baker s''est engagé dans l''armée à ses dix-huit ans. Vétéran de trois guerres, Baker était l''agent du SAS en service actif le plus âgé avant d''être recruté par Rainbow.

Très observateur, calculateur et déterminé, le comportement de Baker peut parfois sembler impatient et cynique, mais il possède un sens profond de la responsabilité éthique. Il est à son meilleur lorsqu''il fait équipe avec de jeunes agents ayant de fortes convictions morales, qu''il peut former. ','1661/06/22',NULL,NULL,2,2,9,5);
INSERT INTO `operateur` VALUES (3,'
James Porter','Smoke','Porter est un amoureux du risque qui attache très peu d''importance à sa sécurité personnelle. Il n''a peur de rien au combat et peut être un atout majeur lors des manœuvres défensives, mais il semble apprécier les ravages et le chaos de la guerre.
','1981/05/1981',NULL,NULL,3,5,4,5);
INSERT INTO `operateur` VALUES (4,'Mark Chandar','Mute','Vétéran du service de renseignements électronique britannique, le Government Communications Headquarters (GCHQ), le travail exceptionnel de Mark Chandar en tant que spécialiste du renseignement d''origine électromagnétique en a fait un élément précieux de Rainbow. ','1991/10/11',NULL,NULL,4,5,5,5);
INSERT INTO `operateur` VALUES (5,'Eliza Cohen','Ash','Eliza Cohen a fait ses débuts en servant dans les FDI de son Israël natal. Elle fait actuellement partie du FBI SWAT dans le cadre d''un programme d''échange d''agents international. ','1983/12/24',NULL,NULL,5,1,10,1);
INSERT INTO `operateur` VALUES (6,'Jordan Trace','Thermite','Ancien marine, Jordan Trace a servi deux ans en Irak et obtenu une licence de chimie après son retour à la vie civile. Après ses études, il a rejoint le FBI en tant qu''agent de terrain et est ensuite passé à l''unité du SWAT. ','1982/03/14',NULL,NULL,6,2,8,1);
INSERT INTO `operateur` VALUES (7,'Miles Campbell','Castle','Miles Campbell a passé une licence de droit pénal et est un ancien officier du SWAT de la police de Los Angeles passé au FBI SWAT, où il est devenu un vétéran. ','1980/09/20',NULL,NULL,7,5,6,1);
INSERT INTO `operateur` VALUES (8,'Jack Estrada','Pulse','Le travail de Jack Estrada au sein du programme de biométrie du FBI lui a permis de combiner sa formation en télécommunications et en biochimie pour un résultat redoutable. ','1984/10/11',NULL,NULL,8,4,1,1);
INSERT INTO `operateur` VALUES (9,'Monika Weiss','IQ','Monika Weiss est une surdouée qui apprend très vite et a naturellement du talent pour presque tout ce qu''elle essaie. Ayant étudié l''ingénierie électrique au sein de l''Ivy League avant de servir dans les unités aériennes et de test technique du GSG9, elle utilise un appareil qui détecte les pièges et les gadgets électroniques à distance.','1979/08/01',NULL,NULL,9,1,11,2);
INSERT INTO `operateur` VALUES (10,'Elias Kötz','Blitz','Connu pour sa tendance à faire de l''humour afin de détendre les situations stressantes, Elias Kötz utilise un matériel tout aussi atypique lors des opérations : un bouclier antiémeute équipé de grenades flash aveuglantes pouvant étourdir les ennemis tout en offrant une protection substantielle. ','1980/04/02',NULL,NULL,10,2,14,2);
INSERT INTO `operateur` VALUES (11,'Dominic Brunsmeier','Bandit','Ancien agent infiltré au sein des Hells Angels d''Hanovre, Brunsmeier est connu pour transformer des objets obsolètes en armes. Il a bricolé un appareil pouvant électrifier les barbelés et les barricades, blessant ou détruisant tout ce qui entre en contact avec eux. ','1974/08/13',NULL,NULL,11,4,5,2);
INSERT INTO `operateur` VALUES (12,'Marius Streicher','Jager','Vétéran des opérations antipiraterie du GSG9 dans l''Océan Indien, Marius Streicher a sillonné le champ de bataille en tant que pilote d''hélicoptère et conseiller en technologie. ','1978/03/09',NULL,NULL,12,4,7,2);
INSERT INTO `operateur` VALUES (13,'SHUHRAT KESSIKBAYEV','Fuze','Shuhrat Kessikbayev a grandi dans une famille militaire de Samarcande, en Ouzbékistan. Il a émigré en Russie peu avant la chute de l''Union soviétique. C''est un bricoleur et un artisan de génie, plus à l''aise avec les machines qu''avec les gens. ','1982/10/12',NULL,NULL,13,3,13,7);
INSERT INTO `operateur` VALUES (14,'TIMUR GLAZKOV','Glaz','Timur Glazkov est un tireur d''exception qui a exercé lors du conflit en Ossétie du Sud et a protégé des personnalités célèbres pendant des années. ','1987/07/02',NULL,NULL,14,2,14,7);
INSERT INTO `operateur` VALUES (15,'MAXIM BASUDA','Kapkan','Né et élevé à Kovrov, Basuda est fils d''ouvriers russes. Pour échapper à une vie à l''usine, il s''est engagé au Ministère des affaires intérieures et a été envoyé dans une petite ville portuaire de la mer de Barents. Basuda est devenu un chasseur et un trappeur passionné pendant le temps qu''il a passé dans le cercle arctique. ','1979/05/14',NULL,NULL,15,5,6,7);
INSERT INTO `operateur` VALUES (16,'ALEXANDR SENAVIEV','Tachanka','Alexsandr Senaviev est un iconoclaste qui a passé son enfance dans une famille de l''Armée rouge pré-glasnost et a depuis conservé son intérêt pour les machines et armes soviétiques.','1967/11/03',NULL,NULL,16,6,4,7);
INSERT INTO `operateur` VALUES (17,'Emmanuelle Pichon','Twitch','Née dans la ville historique de Nancy, Pichon a grandi dans une famille qui prisait l''éducation, surtout en mathématiques et en sciences. Elle a participé très jeune à des compétitions de programmation informatique parrainées, ce qui l''a amenée à rejoindre les cadets de l''armée à seize ans. ','1988/10/12',NULL,NULL,17,2,9,4);
INSERT INTO `operateur` VALUES (18,'Gilles Touré','Montagne','Vétéran de la gendarmerie nationale française, Gilles Touré est l''agent du GIGN ayant le plus d''ancienneté. Très protecteur envers ses coéquipiers, ce doux géant n''hésiterait pas à se placer sur la trajectoire d''une balle pour que ses alliés agents ne soient pas blessés. Il brandit un bouclier antiémeute extra-large, fabriqué dans les années 80, qui a vu plus de batailles que beaucoup d''agents.','1968/10/11',NULL,NULL,18,3,14,4);
INSERT INTO `operateur` VALUES (19,'Gustave Kateb','Doc','Kateb a grandi dans une famille bourgeoise du seizième arrondissement de Paris. À vingt ans, il a délaissé un cabinet médical privé bien achalandé au profit d''une carrière au sein du service de santé des forces de défense françaises. ','1977/09/16',NULL,NULL,19,6,7,4);
INSERT INTO `operateur` VALUES (20,'Julien Nizan','Rook','Julien Nizan est le créateur du célèbre exercice de confiance du GIGN pour les nouvelles recrues : recevoir une balle tirée par l''un de vos collègues avec une petite plaque d''armure pour seule protection. Il porte ces plaques d''armure en combat et les dépose pour ses alliés afin qu''ils renforcent leurs défenses. ','1990/01/06',NULL,NULL,20,6,7,4);
INSERT INTO `operateur` VALUES (21,'Tina Lin Tsang','Frost','Officier de systèmes de combat, Tina Lin Tsang est très concentrée et méticuleuse. Elle utilise le Sterling Mk2 LHT ou “Tapis rouge”, un piège au sol qui lui permet d''immobiliser sa proie sans la tuer. L''aspect épuré du “Tapis rouge” lui permet d''être déployé dans de nombreux environnements et zones sans nécessiter de camouflage spécifique. ','1985/05/04',NULL,NULL,21,5,6,6);
INSERT INTO `operateur` VALUES (22,'Sébastien Côté','Buck','Né et élevé à Montréal, Sébastien Côté est quelqu''un de très pragmatique qui préfère les appareils mécaniques simples à l''arsenal high-tech utilisé par d''autres Agents. Le Passe-partout, un fusil à pompe de calibre 12 monté sous son arme, permet à Côté de passer rapidement des tirs de longue portée aux combats rapprochés, en changeant la position de ses mains sur son fusil d''assaut. ','1980/08/20',NULL,NULL,22,2,10,6);
INSERT INTO `operateur` VALUES (23,'Craig Jenson','BlackBeard','Né et élevé dans le Pacifique Nord-Ouest, Craig « Blackbeard » Jenson décida très jeune de devenir Navy SEAL et consacra sa vie à la réalisation de cet objectif. Il considère les SEAL comme un mélange idéal d’aptitudes mentales et physiques et vise à optimiser ces deux traits en lui-même. ','1985/03/12',NULL,NULL,23,2,11,9);
INSERT INTO `operateur` VALUES (24,'Meghan J. Castellano','Valkyrie','Lorsqu’elle était agente de renseignements de la marine, Castellano fut choisie pour être l’une des premières femmes admises à la formation des SEAL. Particulièrement concentrée et entraînée, elle fera tout pour accomplir la mission de la manière la plus directe et efficace possible.','1986/07/21',NULL,NULL,24,5,2,9);
INSERT INTO `operateur` VALUES (25,'Vicente Souza','Capitão','Vicente "Capitão" Souza est né à Nova Iguacu, près de Rio de Janeiro, où il a également grandi. À sa sortie du lycée, il a été recruté par le Cooredenadoria de Recursos Especiais (le CORE), mais lors d''une embuscade pendant une intervention urbaine, Souza a été capturé, puis torturé pendant deux mois. S''il a enduré son calvaire avec stoïcisme, les blessures qu''il a reçues sont irrémédiables, mais l''ont poussé à mettre au point des stratégies tout à fait inédites, ce qui n''a pas manqué d''attirer l''attention du BOPE. ','1967/11/17',NULL,NULL,25,1,13,16);
INSERT INTO `operateur` VALUES (26,'Taina Pereira','Caveira','Réputée pour ses interrogatoires musclés, Taina "Caveira" Pereira est un agent tout aussi redoutable une fois sur le terrain. Originaire d''une petite ville de la périphérie de São Paulo, son existence aurait pu mal tourner dès ses 16 ans, quand elle fut arrêtée pour vol. Heureusement pour elle, son profil prometteur lui a valu un traitement exceptionnel : le choix entre intégrer un "centre éducatif fermé" et travailler avec le BOPE. ','1989/10/15',NULL,NULL,26,4,1,16);
INSERT INTO `operateur` VALUES (27,'Yumiko Imagawa','Hibana','Originaire de Nagoya, au Japon, Imagawa est experte dans l’art de pénétrer dans les zones à haut risque. À 18 ans, elle entre à l’académie nationale de police grâce à ses talents en arts martiaux. Elle tient son surnom « Hibana » de son commandement explosif sur le terrain, où elle a acquis une rare souplesse tactique en s’entraînant avec le SWAT du FBI et le GIGN. Son esprit d’équipe et sa grande connaissance des tactiques éclair lui ont permis d’intégrer l’unité spéciale du Département de la préfecture de police d’Aichi. ','1983/07/12',NULL,NULL,27,1,8,14);
INSERT INTO `operateur` VALUES (28,'Masaru Enatsu','Echo','Prodige avéré de la robotique, Masaru Enatsu a grandi dans l’arrondissement de Suginami, à Tokyo, berceau de nombreux studios d’animation et d’entreprises technologiques. Séduit par l’idée de tester ses appareils sur le terrain, il entre à l’académie nationale de police. Il se spécialise dans les opérations de reconnaissance et rejoint l’unité spéciale du Département de la Police métropolitaine de Tokyo, avant d’être transféré à Aichi. ','1980/10/31',NULL,NULL,28,6,4,14);
INSERT INTO `operateur` VALUES (29,'Ryad Ramirez Al-Hassar','Jackal','Né à Ceuta en Espagne, Ryad Ramírez Al-Hassar fait preuve d’une grande ingéniosité sur les terrains difficiles, ce qui fait de lui un traqueur expert. Sa formation intensive à l’extérieur du Cuerpo Nacional de Policía (Corps national de police) comprend plusieurs cours de survie, des programmes tactiques de navigation dans le désert et des exercices spécialisés de combat sous-marin. Ramírez est reconnu comme l’un des meilleurs atouts du G.E.O. pour repérer les cibles à valeur élevée et intercepter les expéditions de stupéfiants. Il est impitoyable sur le terrain et déterminé à résoudre les événements qui ont conduit à la perte de son frère aîné, Faisal. ','1968/02/29',NULL,NULL,29,2,11,13);
INSERT INTO `operateur` VALUES (30,'Elena Maria Alvarez del Manzano ','Mira','Elena María Álvarez est née à Retiro, Madrid, où elle a appris à détecter et à réparer les défectuosités mécaniques sur les moteurs d’automobile. Démontrant une endurance physique solide et un besoin irrépressible de faire ses preuves, Álvarez a rejoint plus tard le Grupo Especial de Operaciones (G.E.O.). Sa grande connaissance des véhicules lui a permis de devenir une experte dans le domaine balistique. Elle utilise ses connaissances pour concevoir et tester du matériel pare-balles. ','1971/10/18',NULL,NULL,30,6,2,13);
INSERT INTO `operateur` VALUES (31,'Siu Mei Lin','Ying','Siu Mei Lin, portant le nom de code de Ying (luciole), est née dans le district central aisé de Hong Kong. Avant de se joindre à l’unité des affectations particulières, Ying était un agent de protection rapprochée. Ayant développé des habiletés pour les explosifs à courte portée et le combat, elle s’est inscrite à une école de service de sécurité élite après son secondaire. Elle a toutefois réalisé à quel point ses moyens étaient restreints lorsqu’elle était chargée de gérer des enlèvements à haut risque impliquant des échanges d’argent. Déterminée à vouloir changer le monde, elle a orienté sa carrière pour devenir une agente qui agirait en toutes circonstances. Un an plus tard, elle a intégré un entraînement exclusivement réservé aux femmes à Tel-Aviv, en Israël, où elle a perfectionné le combat corps à corps et les manœuvres de conduites ','1987/07/12',NULL,NULL,31,2,13,3);
INSERT INTO `operateur` VALUES (32,'Liu Tze Long ','Lesion','Liu Tze Long, portant le nom de code de Lesion, est né à Junk Bay. Il a été éduqué par son père, qui travaillait pour une entreprise de démantèlement de bateaux. Pendant ces années, Lesion passait du temps sur le chantier maritime pour aider son père à démanteler des bateaux désuets pour le rebut. Croulant sous les dettes après que son père ait été blessé, Lesion s’est déniché quelques emplois dangereux dans le domaine de la démolition jusqu’à ce qu’il trouve un emploi en déminage. Comme il démontrait un calme naturel lors de la manipulation de substances fortement corrosives, Lesion s’est ajouté à l’effectif du Bureau en neutralisation des explosifs et munitions. Il est reconnu comme un expert en menaces terroristes chimiques, biologiques, radiologiques et nucléaires (CBRN). ','1972/07/02',NULL,NULL,32,5,6,3);
INSERT INTO `operateur` VALUES (33,'Grace Nam','Dokkaebi','Née et élevée à Séoul, en Corée du Sud, Grace Nam n’a jamais rien fait comme les autres : elle récupérera ou achètera notamment des pièces détachées pour monter ses propres ordinateurs. Ses compétences lui valurent de recevoir une bourse nationale au KAIST (l’Institut supérieur coréen des sciences et technologies), mais elle décida de s’enrôler dans l’armée à la fin de ses études. Sa forme physique et son audace porteront leur fruit, puisqu’elle sera placée sous le commandement militaire de l’armée de la République sud-coréenne avant de rejoindre la 9e Brigade des forces spéciales, les Ghosts. Malgré un comportement peu orthodoxe au sein de l’armée sud-coréenne extrêmement disciplinée, elle se fera remarquer pour ses compétences technologiques remarquables et sa grande capacité d’adaptation aux situations. Les instructeurs américains encouragèrent Grace à tenter sa chance au 707th Special Mission Battalion après avoir suivi un entrainement commun avec les bérets verts du détachement K. ','1988/02/02',NULL,NULL,33,2,14,10);
INSERT INTO `operateur` VALUES (34,'Chul Kyung Hwa','Vigil','Chul Kyung Hwa a très peu de souvenirs de son enfance, si ce n’est que sa famille était en fuite à travers l’Asie. Il se souvint de la noyade de son frère ainé lors de la traversée d’une rivière, de sa mère malade abandonnée dans la jungle, et de son père lui enjoignant de ne pas pleurer ni de faire de bruit afin de ne pas alerter les patrouilles armées. Obtenir l’asile en Corée du Sud n’était pas vraiment la vie qu’ils avaient espérée. Rongé par la culpabilité, son père se suicida. Chul Kyung fut adopté par la famille Hwa, qui lui conseilla d’oublier le passé, y compris son véritable nom. Souhaitant se racheter auprès de la Corée du Sud, le pays qui l’avait accueilli, Chul Kyung entra dans la Marine sud-coréenne, où il s’avéra être un matelot exemplaire. Son comportement lui valut de rejoindre l’unité spéciale UDT/SEALs de la marine de guerre sud-coréenne. Il y devint un agent si compétent que le 707th Special Mission Battalion le choisit personnellement. ','1984/01/17',NULL,NULL,34,4,1,10);
INSERT INTO `operateur` VALUES (35,'Lera Melnikova','Finka','Née à Gomel en Biélorussie, trois ans après le désastre de Tchernobyl, Lera Melnikova a été diagnostiquée comme atteinte de neuropathie : dégénérescence musculaire lente et perte de sensation au niveau des membres et des extrémités. Elle s’est forcée à garder une excellente condition physique afin de surmonter ses symptômes. Puis, elle a déménagé à Novossibirsk et a obtenu un doctorat en microbiologie et immunologie, ce qui lui a permis de découvrir des traitements à base de nanorobots solubles. Si elle n’est pas parvenue à trouver un remède pour sa neuropathie, elle a découvert des moyens d’atténuer ses effets. Ses recherches ont protégé des agents contre des matériaux dangereux grâce à quoi elle a pu entrevoir de nouvelles possibilités. Elle s’est donc enrôlée, puis elle est devenue une spécialiste NRBC de la Spetsnaz. Pour savoir d’où vient son surnom Finka, il faut demander à Kapkan ou à Lera, elle-même.','1989/06/07',NULL,NULL,35,2,13,8);
INSERT INTO `operateur` VALUES (36,'Olivier Flament','Lion','Olivier Flament a grandi à Toulouse, en France, où il a toujours entretenu des rapports antagonistes avec sa famille et ne partageait pas leur foi en Dieu. Ses parents ont fini par le mettre à la porte et il s’est retrouvé sans domicile à 18 ans. Il s’est engagé dans l’armée française en désespoir de cause, puis a rejoint le 2e régiment de dragons afin d’intervenir pour les missions NRBC. Le GIGN l’a recruté en tant qu’expert en risque biologique. Lors d’une mission au Soudan, une épidémie de fièvre jaune a fait rage. Alors qu’il protégeait une équipe d’investigation sur place, il s’est exprimé si fort qu’il a fait reculer une foule entière. C’est ainsi que les gens de la région lui donnèrent le surnom de « Lion ». Après avoir étudié son dossier, Finka a recommandé qu’Olivier intègre Rainbow en tant que spécialiste NRBC. Cependant, le poids de ses regrets ne figure pas dans son dossier.','1985/08/29',NULL,NULL,36,2,14,8);
INSERT INTO `operateur` VALUES (37,'Zofia Bosak','Zofia','La célèbre Zofia Bosak, officière décorée, rejoint l''équipe Rainbow. Elle est la deuxième spécialiste de l''unité polonaise de contre-terrorisme, le GROM, à intégrer l''équipe Rainbow. La première spécialiste n''est autre que sa sœur cadette, Elzbieta Bosak. Elle fut toujours la fille préférée des deux sœurs, ce qui causa un gouffre entre elles. Suivant un congé de maternité, Sofia revint à GROM après avoir appris qu''Ela avait passé la sélection. Quand Ela accepta l''offre d''intégrer l''équipe prestigieuse de Rainbow, Zofia décida d''en faire autant. Au sein du GROM, tout lui rappelait son père et sa mort tragique. ','1981/01/28',NULL,NULL,37,2,13,11);
INSERT INTO `operateur` VALUES (38,'Elzbieta Bosak','Ela','Elżbieta Bosak est nouvellement arrivée au sein de l’équipe Rainbow. Cette trentenaire déterminée, que l’on surnomme Ela, a un parcours atypique. Après s’être rapidement hissée à la tête des Forces Spéciales de la Pologne, elle a été déployée dans six pays, notamment en Iraq où elle y a été active pendant sept ans. Il ne faut pas se surprendre de ses exploits, étant donné qu’elle est la fille cadette de Jan Bosak, un ancien commandant du Groupe de réaction opérationnelle et de manœuvres (GROM),l’unité contre-terrorisme de Pologne. En dépit de cet héritage et contrairement à ce qu’on pourrait s’imaginer, Ela n’est pas une soldate rigide. Ela a connu quelques difficultés lorsqu’elle fréquentait une école secondaire militaire. Comme elle était la fille du commandant du Groupe de réaction opérationnelle et de manœuvres (GROM), Ela se faisait constamment intimider en raison de l’attention particulière qu’elle recevait. ','1985/11/08',NULL,NULL,38,4,6,11);
DROP TABLE IF EXISTS `gadgetOperateur`;
CREATE TABLE IF NOT EXISTS `gadgetOperateur` (
	`idGadget`	INTEGER,
	`idOperateur`	INTEGER,
	`qteGadget`	INTEGER,
	PRIMARY KEY(`idGadget`,`idOperateur`),
	FOREIGN KEY(`idOperateur`) REFERENCES `operateur`(`idOperateur`),
	FOREIGN KEY(`idGadget`) REFERENCES `gadget`(`idGadget`)
);
INSERT INTO `gadgetOperateur` VALUES (6,1,2);
INSERT INTO `gadgetOperateur` VALUES (5,1,3);
INSERT INTO `gadgetOperateur` VALUES (2,2,1);
INSERT INTO `gadgetOperateur` VALUES (3,2,3);
INSERT INTO `gadgetOperateur` VALUES (8,3,2);
INSERT INTO `gadgetOperateur` VALUES (4,3,2);
INSERT INTO `gadgetOperateur` VALUES (9,4,1);
INSERT INTO `gadgetOperateur` VALUES (1,4,1);
INSERT INTO `gadgetOperateur` VALUES (3,5,3);
INSERT INTO `gadgetOperateur` VALUES (5,5,3);
INSERT INTO `gadgetOperateur` VALUES (5,6,3);
INSERT INTO `gadgetOperateur` VALUES (2,6,1);
INSERT INTO `gadgetOperateur` VALUES (1,7,1);
INSERT INTO `gadgetOperateur` VALUES (8,7,2);
INSERT INTO `gadgetOperateur` VALUES (4,8,2);
INSERT INTO `gadgetOperateur` VALUES (9,8,1);
INSERT INTO `gadgetOperateur` VALUES (3,9,3);
INSERT INTO `gadgetOperateur` VALUES (6,9,2);
INSERT INTO `gadgetOperateur` VALUES (7,10,2);
INSERT INTO `gadgetOperateur` VALUES (3,10,3);
INSERT INTO `gadgetOperateur` VALUES (4,11,2);
INSERT INTO `gadgetOperateur` VALUES (9,11,1);
INSERT INTO `gadgetOperateur` VALUES (1,12,1);
INSERT INTO `gadgetOperateur` VALUES (4,12,2);
INSERT INTO `gadgetOperateur` VALUES (3,13,3);
INSERT INTO `gadgetOperateur` VALUES (7,13,2);
INSERT INTO `gadgetOperateur` VALUES (7,14,2);
INSERT INTO `gadgetOperateur` VALUES (2,14,1);
INSERT INTO `gadgetOperateur` VALUES (8,15,2);
INSERT INTO `gadgetOperateur` VALUES (9,15,1);
INSERT INTO `gadgetOperateur` VALUES (4,16,2);
INSERT INTO `gadgetOperateur` VALUES (1,16,1);
INSERT INTO `gadgetOperateur` VALUES (3,17,3);
INSERT INTO `gadgetOperateur` VALUES (2,17,1);
INSERT INTO `gadgetOperateur` VALUES (5,18,3);
INSERT INTO `gadgetOperateur` VALUES (6,18,2);
INSERT INTO `gadgetOperateur` VALUES (4,19,2);
INSERT INTO `gadgetOperateur` VALUES (1,19,1);
INSERT INTO `gadgetOperateur` VALUES (1,20,1);
INSERT INTO `gadgetOperateur` VALUES (8,20,2);
INSERT INTO `gadgetOperateur` VALUES (1,21,1);
INSERT INTO `gadgetOperateur` VALUES (4,21,2);
INSERT INTO `gadgetOperateur` VALUES (5,22,3);
INSERT INTO `gadgetOperateur` VALUES (6,22,2);
INSERT INTO `gadgetOperateur` VALUES (3,23,3);
INSERT INTO `gadgetOperateur` VALUES (5,23,3);
INSERT INTO `gadgetOperateur` VALUES (1,24,1);
INSERT INTO `gadgetOperateur` VALUES (9,24,1);
INSERT INTO `gadgetOperateur` VALUES (2,25,1);
INSERT INTO `gadgetOperateur` VALUES (5,25,3);
INSERT INTO `gadgetOperateur` VALUES (8,26,2);
INSERT INTO `gadgetOperateur` VALUES (4,26,2);
INSERT INTO `gadgetOperateur` VALUES (5,27,3);
INSERT INTO `gadgetOperateur` VALUES (2,27,1);
INSERT INTO `gadgetOperateur` VALUES (4,28,2);
INSERT INTO `gadgetOperateur` VALUES (1,28,1);
INSERT INTO `gadgetOperateur` VALUES (3,29,3);
INSERT INTO `gadgetOperateur` VALUES (7,29,2);
INSERT INTO `gadgetOperateur` VALUES (1,30,1);
INSERT INTO `gadgetOperateur` VALUES (9,30,1);
INSERT INTO `gadgetOperateur` VALUES (3,31,3);
INSERT INTO `gadgetOperateur` VALUES (7,31,2);
INSERT INTO `gadgetOperateur` VALUES (8,32,2);
INSERT INTO `gadgetOperateur` VALUES (1,32,1);
INSERT INTO `gadgetOperateur` VALUES (7,33,2);
INSERT INTO `gadgetOperateur` VALUES (2,33,1);
INSERT INTO `gadgetOperateur` VALUES (4,34,2);
INSERT INTO `gadgetOperateur` VALUES (8,34,2);
INSERT INTO `gadgetOperateur` VALUES (3,35,3);
INSERT INTO `gadgetOperateur` VALUES (5,35,3);
INSERT INTO `gadgetOperateur` VALUES (2,36,1);
INSERT INTO `gadgetOperateur` VALUES (5,36,3);
INSERT INTO `gadgetOperateur` VALUES (3,37,3);
INSERT INTO `gadgetOperateur` VALUES (2,37,1);
INSERT INTO `gadgetOperateur` VALUES (4,38,2);
INSERT INTO `gadgetOperateur` VALUES (1,38,1);
DROP TABLE IF EXISTS `gadget`;
CREATE TABLE IF NOT EXISTS `gadget` (
	`idGadget`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomGadget`	TEXT,
	`cheminImageGadget`	TEXT
);
INSERT INTO `gadget` VALUES (1,'Bouclier Déployable',NULL);
INSERT INTO `gadget` VALUES (2,'Claymore',NULL);
INSERT INTO `gadget` VALUES (3,'Charge explosive',NULL);
INSERT INTO `gadget` VALUES (4,'Fil barbelés',NULL);
INSERT INTO `gadget` VALUES (5,'Grenade Flash',NULL);
INSERT INTO `gadget` VALUES (6,'Grenade Frag',NULL);
INSERT INTO `gadget` VALUES (7,'Grenade Fumigène',NULL);
INSERT INTO `gadget` VALUES (8,'Grenade à impact',NULL);
INSERT INTO `gadget` VALUES (9,'Nitro',NULL);
DROP TABLE IF EXISTS `degat`;
CREATE TABLE IF NOT EXISTS `degat` (
	`idDegat`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`damageStandardClose`	TEXT,
	`damageStandardFar`	TEXT,
	`damageSuppressedClose`	TEXT,
	`damageSuppressedFar`	TEXT,
	`damageExtendedClose`	TEXT,
	`damageExtendedFar`	TEXT,
	`idArme`	INTEGER,
	FOREIGN KEY(`idArme`) REFERENCES `arme`(`idArme`)
);
INSERT INTO `degat` VALUES (1,'47 (0-25m)','29 (35+m)','39 (0-25m)','25 (35+m)',NULL,NULL,1);
INSERT INTO `degat` VALUES (2,'41 (0-25m)','24 (35+m)','35 (0-25m)','20 (35+m)',NULL,NULL,2);
INSERT INTO `degat` VALUES (3,'38 (0-25m)','26 (35+m)','32 (0-25m)','22 (35+m)',NULL,NULL,3);
INSERT INTO `degat` VALUES (4,'39 (0-25m)','25 (35+m)','36 (0-25m)','21 (35+m)','39 (0-25m)','35 (35+m)',4);
INSERT INTO `degat` VALUES (5,'46 (0-25m)','25 (35+m)','39 (0-25m)','21 (35+m)',NULL,NULL,5);
INSERT INTO `degat` VALUES (6,NULL,NULL,NULL,NULL,NULL,NULL,6);
INSERT INTO `degat` VALUES (7,NULL,NULL,NULL,NULL,NULL,NULL,7);
DROP TABLE IF EXISTS `ctu`;
CREATE TABLE IF NOT EXISTS `ctu` (
	`idCTU`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomCTU`	TEXT,
	`abrevCTU`	TEXT,
	`locationCTU`	TEXT,
	`descCTU`	TEXT
);
INSERT INTO `ctu` VALUES (1,'Federal Bureau of Investigation - Special Weapons and Tactics Teams','FBI SWAT','USA','SWAT agents are specially trained to intervene in high-risk events like a hostage and barricade situations. The FBI maintains SWAT teams at each of its 56 field offices throughout the country varying in size up to about 42 members. In the event of a large-scale problem that local law enforcement does not have the resources to handle, FBI SWAT teams from the local field office, as well as outside the local region can be dispatched to aid the local authorities.');
INSERT INTO `ctu` VALUES (2,'Grenzschutzgruppe 9 der Bundespolizei (Border Protection Group 9 of the Federal Police)','GSG-9','Allemagne','German counter-terrorism and special operations unit. It was created as a result of the Munich Massacre where Germany''s law enforcement found itself severely compromised due to their failure to rescue the hostages and stop the terrorists as well as the country''s historic relationship to Jews and Israel. ');
INSERT INTO `ctu` VALUES (3,'Special Duties Unit','SDU','Chine','Hong Kong''s main elite paramilitary special operations unit. The SDU is a subdivision of the Police Tactical Unit (PTU) of the Hong Kong Police Force. ');
INSERT INTO `ctu` VALUES (4,'Groupe d''Intervention de la Gendarmerie Nationale','GIGN','France','GIGN is a special operations unit of the French Armed Forces. It is part of the National Gendarmerie and is trained to perform counter-terrorism and hostage rescue missions in France or anywhere else in the world. ');
INSERT INTO `ctu` VALUES (5,'Special Air Service','SAS','Royaume-Uni','SAS is a special forces regiment of the British Army, first active from 1941 to 1945, then from 1947 onward. They conduct diverse unconventional warfare. Before entering, soldiers go through a difficult training course called "Selection". If a soldier passes, they are transferred into either the air, boat, or mobility unit. As well as this, all three regiments that form the Special Air Service have a main and reserve counter-terrorism unit. ');
INSERT INTO `ctu` VALUES (6,'Joint Task Force 2 ','JTF2','Canada','JTF2 is an elite special operations force of the Canadian Forces, primarily tasked with counter-terrorism operations. Activated in 1993, it is currently based at Dwyer Hill, near Ottawa, Ontario, and plans to move to a new facility to be built at CFB Trenton by 2019. ');
INSERT INTO `ctu` VALUES (7,'Russian Special Purpose Forces','Spetsnaz','Russie','Created in 1974, the Spetsnaz are members of Russian units dedicated to counter-terrorism, paramilitary and covert operations. They''re tasked with protecting Russia''s strategic installations, both domestic and international, though little is known is about the exact nature of their mission.');
INSERT INTO `ctu` VALUES (8,'Chemical, Biological, Radiological, Nuclear Threat Unit','CBRN','Worlwide','CBRN is a counter-terrorism unit of Team Rainbow. It was founded by Six to answer growing threats of biological and chemical attacks. ');
INSERT INTO `ctu` VALUES (9,'Navy''s Sea, Air and Land Teams','Navy SEALs','USA','Navy SEALs are the U.S. Navy''s principal special operations force and a part of the Naval Special Warfare Command and United States Special Operations Command. They are trained to operate in all environments (Sea, Air, and Land) for which they are named and are also prepared to operate in a variety of climates, such as desert, arctic, and jungle. ');
INSERT INTO `ctu` VALUES (10,'707th Special Mission Battalion','707th SMB','Corée du Sud','707th SMB is a special forces unit in the Republic of Korea Army Special Warfare Command. The unit was formed after the Munich massacre, which forced the South Korean government to create a counter-terrorist unit in time for the 1988 Olympics that would be held on South Korean soil. The unit has about 200 men and women organized in two companies, headquarters and support staff.');
INSERT INTO `ctu` VALUES (11,'Military Unit GROM named in honour of the Silent Unseen of the Home Army','JW GROM','Pologne','JW GROM is Poland''s elite counter-terrorism unit. GROM, which stands for Grupa Reagowania Operacyjno-Manewrowego (English: Group (for) Operational Maneuvering Response), which also means "thunder", is one of the five special operation forces units of the Polish Armed Forces. It was officially activated on July 13, 1990. It is deployed in a variety of special operations and unconventional warfare roles, including anti-terrorist operations and projection of force behind enemy lines. ');
INSERT INTO `ctu` VALUES (12,'Gruppo di Intervento Speciale','GIS','Italie','GIS is an elite airborne special operations counter-terrorism tactical response unit inside the Italian Carabinieri military police, first formed in 1977. In 2004 the GIS evolved into a special forces unit. The unit has taken part in counter-terrorism operations and VIP, executive and dignitary protection security details ever since the inception of the GIS. ');
INSERT INTO `ctu` VALUES (13,'Grupo Especial de Operaciones','GEO','Espagne','GEOs are the special operations forces of the Spanish Cuerpo Nacional de Policía (English: National Police Corps).The GEO has response capabilities and is responsible for VIP protection duties, as well as countering and responding to terrorism. ');
INSERT INTO `ctu` VALUES (14,'Special Assault Team','SAT','Japon','SAT is a counter-terrorism unit in some Prefectural Police Departments supervised by the Japanese National Police Agency. Its origin can be traced back to the Special Armed Police who were trained in September 1977 to combat criminal incidents as a response to the Dhaka Incident. They saw their first successful deployment in January 1979 during the Mitsubishi Bank hostage incident and were involved in many other counter-terrorist operations since then. These specially trained SAP members were officially put into the newly established Special Assault Team in 1996 after training for a year with the GSG 9, GIGN, and British SAS. ');
INSERT INTO `ctu` VALUES (15,'Groupe d''Intérvention de La Gendarmerie Royale ','GIGR','Maroc','GIGR is a set of specially trained military units, educated and trained to carry out a range of specific missions, from "special operations" as part of a conventional conflict with those under the unconventional warfare. ');
INSERT INTO `ctu` VALUES (16,'Batalhão de Operações Policiais Especiais','BOPE','Brézil','BOPE is a special police unit of the Military Police of Rio de Janeiro State (PMERJ) in Brazil. Due to the nature of crime in favelas, BOPE units have extensive experience in urban warfare as well as progression in confined and restricted environments. It also utilizes equipment deemed more powerful than traditional civilian law enforcement. ');
DROP TABLE IF EXISTS `counters`;
CREATE TABLE IF NOT EXISTS `counters` (
	`idOpCountering`	INTEGER,
	`idOpCountered`	INTEGER,
	PRIMARY KEY(`idOpCountering`,`idOpCountered`),
	FOREIGN KEY(`idOpCountered`) REFERENCES `operateur`(`idOperateur`),
	FOREIGN KEY(`idOpCountering`) REFERENCES `operateur`(`idOperateur`)
);
DROP TABLE IF EXISTS `capacite`;
CREATE TABLE IF NOT EXISTS `capacite` (
	`idCap`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomCap`	TEXT,
	`descCap`	TEXT,
	`cheminImageCap`	TEXT,
	`idOperateur`	INTEGER
);
INSERT INTO `capacite` VALUES (1,'Le Tronc ','Marteau de démolition qui peut être utilisé pour traverser rapidement plusieurs murs, planchers et barricades destructibles. ',NULL,1);
INSERT INTO `capacite` VALUES (2,'Grenade IEM EG MKO','Grenade IEM qui détruit et désactive tout les appareils électronique se trouvant dans son périmètre d''explosion.',NULL,2);
INSERT INTO `capacite` VALUES (3,'Composé Z8 ','Mine à dispersion avec détonation à distance remplie d''un gaz à la composition inconnue pour gêner les avancées ennemies. ',NULL,3);
INSERT INTO `capacite` VALUES (4,'Brouilleur de signaux "Moni" GC90','Brouilleur de signaux permettant de perturber toutes les communications dans une zone donnée, empêchant les détonations à distance et l''utilisation de drones.',NULL,4);
INSERT INTO `capacite` VALUES (5,'MOFC M120 ','Explosifs utilisables comme munitions pouvant souffler une porte ou un mur à distance. ',NULL,5);
INSERT INTO `capacite` VALUES (6,'Soufre CS-3 ','Explosifs développés avec l''aide de l''équipe d''ingénierie du FBI SWAT qui peuvent traverser même les barrières les plus résistantes',NULL,6);
INSERT INTO `capacite` VALUES (7,'Panneau tactique universel PTU1','Panneau de blindage enroulable en poluéthylène, tissu balistique et micro-plaques en céramique de bore.',NULL,7);
INSERT INTO `capacite` VALUES (8,'Senseur cardiaque P-5 ','Ce détecteur de pouls peut lire les signatures thermiques au travers des murs et des autres obstacles',NULL,8);
INSERT INTO `capacite` VALUES (9,'« Spectre » RED MKIII ','Détecteur d''électronique',NULL,9);
INSERT INTO `capacite` VALUES (10,'Bouclier tactique G52 ','Bouclier flash qui aveugle toute cible qui le regarde et qui est à portée.',NULL,10);
INSERT INTO `capacite` VALUES (11,'AEI-1 (Appareil électrique improvisé) ','Appareil pouvant électrifier les barbelés et les barricades, blessant ou détruisant tout ce qui entre en contact avec eux. ',NULL,11);
INSERT INTO `capacite` VALUES (12,'« Faucon » SDA-MK IV ','Système de défense active capable de neutraliser tout projectile en approche. ',NULL,12);
INSERT INTO `capacite` VALUES (13,'« Poupée russe » APM-6','Charge à grappe qui, lorsqu''elle est plantée dans un mur ou dans un plancher, y perce un trou en libérant un groupe de petites grenades à fragmentation. ',NULL,13);
INSERT INTO `capacite` VALUES (14,'Viseur amovible HDS ','Lunette grossissante pour transformer le Dragunov en fusil à longue portée mortel. ',NULL,14);
INSERT INTO `capacite` VALUES (15,'EAI Mk II ','Piège pour les fenêtres et les portes qui fera à coup sûr obstacle à tout ennemi (ou allié) pris dans son explosion. ',NULL,15);
INSERT INTO `capacite` VALUES (16,'Mitraillette RP-46 Degtyaryov','Vieille mitraillette montée.',NULL,16);
INSERT INTO `capacite` VALUES (17,'DCR Modèle 1','Petit drone pouvant administrer des chocs électriques d''étourdissement ou de désactivation aux forces ennemies et à leurs pièges. ',NULL,17);
INSERT INTO `capacite` VALUES (18,'Le Roc ','Bouclier extensible qui couvre entièrement de la tête aux pieds lorsqu''il est debout, fournissant un couvert supplémentaire pour lui et ceux qui se tiennent derrière lui. ',NULL,18);
INSERT INTO `capacite` VALUES (19,'Pistolet stim MPD-0 ','Pistolet stim qui permet de ranimer les coéquipiers à terre à distance. ',NULL,19);
INSERT INTO `capacite` VALUES (20,'Armure R1N « Rhino » ','Pack d''armure : chaque plaque d''armure R1N « Rhino » augmentera les chances que le porteur soit mis à terre lorsqu''il reçoit un tir au lieu d''être tué. ',NULL,20);
INSERT INTO `capacite` VALUES (21,'STERLING MK2 LHT (TAPIS ROUGE)','Composé d’un socle et de mâchoires métalliques, ce piège se déclenche, lorsqu''un ennemi pose le pied sur la plaque, deux séries de mâchoires se déploient à hauteur des chevilles et tibias, empêchant l''individu de s''échapper.
La pression des mâchoires est telle qu’il est nécessaire d''être deux afin de desserrer les mâchoires et remettre le piège en place.

',NULL,21);
INSERT INTO `capacite` VALUES (22,'SK 4-12 (Le Passe-partout) ','Un fusil à pompe de calibre 12 monté sous son arme, utilisé en association avec un fusil d''assaut.

',NULL,22);
INSERT INTO `capacite` VALUES (23,'TARS Mk 0','Blindage thermoplastique composé de plusieurs couches de polycarbonate transparent, recouvert d’un bouclier anti-éclats et posé sur du verre feuilleté ultraléger.',NULL,23);
INSERT INTO `capacite` VALUES (24,'GYRO CAM MK2','Enfermé dans une boule en silicone teinté, recouvert de mini-ventouses, l’appareil photo à déploiement rapide maintient une vision claire grâce au gyroscope interne qui ajuste l’angle de la lentille. 
Le flux vidéo en direct est disponible pour tous les opérateurs.',NULL,24);
INSERT INTO `capacite` VALUES (25,'TAC MK0 ','Utilisez un carreau en verre pour attaquer silencieusement et rapidement vos ennemis sans leur révéler votre position. La cartouche en verre se brise à l’impact, ce qui dégage un gaz qui enflamme l’oxygène aux alentours. Lancez des assauts rapides et vifs sans révéler votre position à vos adversaires.',NULL,25);
INSERT INTO `capacite` VALUES (26,'Luison ','Le « Luison » est recouvert d’une fibre minérale à base de roche qui permet d’isoler et d’insonoriser le silencieux. Cette arme permet à Caveira de maîtriser discrètement sa cible et de l’interroger.',NULL,26);
INSERT INTO `capacite` VALUES (27,'X-KAIROS ','Le X-KAIROS, un lance-roquette de calibre 40 mm, tire des projectifs explosifs pouvant être déclenchés simultanément à distance.',NULL,27);
INSERT INTO `capacite` VALUES (28,'YOKAI ','Muni d’un dispositif de brouillage acoustique, ce drone emblématique peut émettre des salves d’ultrasons qui désorientent toutes les cibles situées dans un périmètre donné. De plus, Echo peut en permanence sécuriser le périmètre immédiat grâce au système de retransmission du flux vidéo de Yokai. ',NULL,28);
INSERT INTO `capacite` VALUES (29,'Le modèle Eyenox III ','Le modèle Eyenox III a été conçu pour offrir un dispositif de suivi mobile capable de suivre les empreintes d’une personne et de l’identifier en temps réel.
Doté d’une vision artificielle avancée, le Eyenox détecte les détails invisibles relatifs à la foulée et à la répartition du poids afin que vous puissiez identifier et traquer votre cible.

',NULL,29);
INSERT INTO `capacite` VALUES (30,'Miroir Noir','Un verre feuilleté spécialisé qui, lorsqu’il est déployé avec de l’oxyacétylène, peut créer un miroir d’observation sur n’importe quel mur.
Toutefois, si la pression de l’air est interrompue, le verre est éjecté et crée une ouverture audacieuse pour les défenseurs et les attaquants.',NULL,30);
INSERT INTO `capacite` VALUES (31,'Appareil Candela','Inspiré du nouveau genre de grenades neutralisantes présenté par le Special Air Service, cet explosif fait de mercure et de magnésium crée une multitude de clignotements aveuglants. 
L’appareil Candela libère une série de clignotements qui peuvent soit être ancrés aux surfaces ou lancés comme grenades.',NULL,31);
INSERT INTO `capacite` VALUES (32,'Mines Gu','Les mines Gu s’inspirent des pointes punji utilisées pendant la guerre du Vietnam. Frictionnés avec des plantes toxiques et des excréments, les piquets servent à ralentir les troupes ennemies en leur causant de graves infections dans leurs campements. 
De la même façon, les mines Gu injectent un venin qui blesse l’adversaire et le limite dans sa vitesse.',NULL,32);
INSERT INTO `capacite` VALUES (33,'Bombe logique','Grace utilise l’ordinateur portable militaire à blindage balistique baptisé Bombe logique pour pirater les dispositifs tactiques ennemis.
Le programme télécharge un virus de son cru capable de contourner les pare-feux, ce qui lui permet d’activer les dispositifs à proximité et d’émettre un bruit assourdissant pour compromettre la position d’un ennemi. Le programme s’exécute rapidement et s’auto-détruit afin d’empêcher quiconque de déchiffrer son code et de développer un logiciel pour contrer la bombe logique.',NULL,33);
INSERT INTO `capacite` VALUES (34,'Système de dissimulation électronique (ERC-7)','Le ERC-7 utilise une technologie de réalité diminuée pour supprimer les stimuli perceptibles de son environnement direct. Vigil porte un prototype dans son sac à dos qui scanne les dispositifs électroniques environnants et efface son image de toute caméra à proximité.',NULL,34);
INSERT INTO `capacite` VALUES (35,'Piqûre de Nanorobots','La poussée d’adrénaline de Finka active des nanorobots pré-injectés et composés de zinc dans le corps des agents, ce qui libère un cocktail pharmacologique dans leur système, les nanorobots se servant du zinc comme élément nutritif. Ces nanorobots donnent à son équipe un bref surplus d’énergie, les aident à se remettre sur pied et améliorent la précision de leurs tirs. Elle est la seule capable d’adapter les nanorobots à la physiologie de chaque agent. ',NULL,34);
INSERT INTO `capacite` VALUES (36,'EE-One-D ','Twitch lui a fourni un drone aérien à l’époque où il travaillait pour le GIGN. EE-ONE-D permet à Lion de maintenir les protocoles de quarantaine en détectant les mouvements dans un périmètre déterminé, ce qui lui donne une vue d’ensemble des zones à risque ou du champ de bataille. Son drone peut rester en vol indéfiniment, mais il faut choisir le bon moment pour balayer le périmètre.',NULL,35);
INSERT INTO `capacite` VALUES (37,'KS79 LIFELINE','Le KS79 LIFELINE utilise une technologie de projectile déclenchée de façon électronique capable de tirer à la fois des munitions à impact et des munitions assourdissantes. Puisque plusieurs grenades sont superposées dans le canon, il n’est plus nécessaire de recharger l’arme, ce qui la rend extrêmement efficace.
Les munitions assourdissantes émettent une onde de choc de 170 décibels qui perturbe l’ouïe et étourdit la cible. Les munitions à impact détruisent les murs en un instant. Préparez-vous à une attaque explosive.',NULL,35);
INSERT INTO `capacite` VALUES (38,'Mines collantes Grzmot','Inspiré des grenades antichars utilisé en 1939 lors du fameux Cichociemni pendant la Deuxième Guerre mondiale,les mines collantes Grzmot peuvent s’ancrer sur les surfaces, altérer l’ouïe et causer des vertiges.
Ces mines à concussion sont déclenchées par la proximité, affectant quiconque dans son rayon.

',NULL,38);
DROP TABLE IF EXISTS `armeOperateur`;
CREATE TABLE IF NOT EXISTS `armeOperateur` (
	`idArme`	INTEGER,
	`idOperateur`	INTEGER,
	FOREIGN KEY(`idArme`) REFERENCES `arme`(`idArme`),
	PRIMARY KEY(`idArme`,`idOperateur`),
	FOREIGN KEY(`idOperateur`) REFERENCES `operateur`(`idOperateur`)
);
DROP TABLE IF EXISTS `arme`;
CREATE TABLE IF NOT EXISTS `arme` (
	`idArme`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomArme`	TEXT,
	`calibreBalle`	TEXT,
	`magSize`	TEXT,
	`maxAmmo`	TEXT,
	`fireRate`	TEXT,
	`mobility`	TEXT,
	`cheminImageArme`	TEXT,
	`idTypeArme`	INTEGER,
	FOREIGN KEY(`idTypeArme`) REFERENCES `typeArme`(`idTypeArme`)
);
INSERT INTO `arme` VALUES (1,'L85A2','5.56x45mm NATO','30','210','670','50',NULL,1);
INSERT INTO `arme` VALUES (2,'AR33','5.56x45mm NATO','25','175','749','50',NULL,1);
INSERT INTO `arme` VALUES (3,'G36C','5.56x45mm NATO','30','210','780','50',NULL,1);
INSERT INTO `arme` VALUES (4,'R4-C','5.56x45mm NATO','30','210','860','50',NULL,1);
INSERT INTO `arme` VALUES (5,'556xi','5.56x45mm NATO','30','210','690','50',NULL,1);
INSERT INTO `arme` VALUES (6,'F2','5.56x45mm NATO','30','210','980','50',NULL,1);
INSERT INTO `arme` VALUES (7,'AK-12','5.45×39mm','30','210','850','50',NULL,1);
INSERT INTO `arme` VALUES (8,'AUG A2','5.56x45mm NATO','30','210','720','50',NULL,1);
INSERT INTO `arme` VALUES (9,'552 Commando','5.56x45mm NATO','30','210','690','50',NULL,1);
INSERT INTO `arme` VALUES (10,'416-C Carbine','5.56x45mm NATO','30','210','740','50',NULL,1);
INSERT INTO `arme` VALUES (11,'C8-SFW','5.56x45mm NATO','30','210','837','50',NULL,1);
INSERT INTO `arme` VALUES (12,'Mk17 CQB','7.62×51mm NATO','20','140','585','50',NULL,1);
INSERT INTO `arme` VALUES (13,'PARA-308','7.62×51mm NATO','30','210','650','50',NULL,1);
INSERT INTO `arme` VALUES (14,'Type-89','7.62×51mm NATO','20','160','850','50',NULL,1);
INSERT INTO `arme` VALUES (15,'C7E','7.62×51mm NATO','30','210','800','50',NULL,1);
INSERT INTO `arme` VALUES (16,'M762','7.62×51mm NATO','30','210','730','50',NULL,1);
INSERT INTO `arme` VALUES (17,'V308','7.62×51mm NATO','50','150','700','50',NULL,1);
INSERT INTO `arme` VALUES (18,'Spear .308','7.62×51mm NATO','30','210','780','50',NULL,1);
INSERT INTO `arme` VALUES (19,'FMG-9','9x19mm Parabellum','30','150','800','50',NULL,7);
INSERT INTO `arme` VALUES (20,'MP5K','9×19mm Parabellum','30','150','800','50',NULL,7);
INSERT INTO `arme` VALUES (21,'UMP45','.45 ACP','25','150','600','50',NULL,7);
INSERT INTO `arme` VALUES (22,'MP5','9×19mm Parabellum','30','150','800','50',NULL,7);
INSERT INTO `arme` VALUES (23,'P90','5.7x28mm','50','200','970','50',NULL,7);
INSERT INTO `arme` VALUES (24,'9x19VSN','9×19mm Parabellum','30','150','750','50',NULL,7);
INSERT INTO `arme` VALUES (25,'MP7','HK 4.6×30mm','30','150','900','50',NULL,7);
INSERT INTO `arme` VALUES (26,'9mm C1','9×19mm Parabellum','34','170','575','50',NULL,7);
INSERT INTO `arme` VALUES (27,'MPX','9x19mm Parabellum','30','150','830','50',NULL,7);
INSERT INTO `arme` VALUES (28,'M12','9x19mm Parabellum','30','150','550','50',NULL,7);
INSERT INTO `arme` VALUES (29,'MP5SD','9×19mm Parabellum','30','150','800','50',NULL,7);
INSERT INTO `arme` VALUES (30,'PDW9','9x19mm Parabellum','50','250','800','50',NULL,7);
INSERT INTO `arme` VALUES (31,'Vector .45 ACP','.45 ACP','25','150','1200','50',NULL,7);
INSERT INTO `arme` VALUES (32,'T-5 SMG','9×19mm Parabellum','30','210','900','50',NULL,7);
INSERT INTO `arme` VALUES (33,'Scorpion EVO 3 A1','9x19mm Parabellum','50','210','1080','50',NULL,7);
INSERT INTO `arme` VALUES (34,'K1A','.223 Remington','30','210','720','50',NULL,7);
INSERT INTO `arme` VALUES (35,'M590A1','12 Gauge Buckshot','7','29','~100','50',NULL,8);
INSERT INTO `arme` VALUES (36,'M1014','12 Gauge Buckshot','7','25','~220','50',NULL,8);
INSERT INTO `arme` VALUES (37,'SG-CQB','12 Gauge Buckshot','6','29','~100','50',NULL,8);
INSERT INTO `arme` VALUES (38,'SASG-12','12 Gauge Buckshot','10','40','~360','50',NULL,8);
INSERT INTO `arme` VALUES (39,'M870','12 Gauge Buckshot','7','29','~120','50',NULL,8);
INSERT INTO `arme` VALUES (40,'Super 90','12 Gauge Buckshot','7','25','~230','50',NULL,8);
INSERT INTO `arme` VALUES (41,'SPAS-12 ','12 Gauge Buckshot','6','29','~230','50',NULL,8);
INSERT INTO `arme` VALUES (42,'SPAS-15','12 Gauge Buckshot','6','30','~320','50',NULL,8);
INSERT INTO `arme` VALUES (43,'SuperNova','12 Gauge Buckshot','6','48','~85','50',NULL,8);
INSERT INTO `arme` VALUES (44,'ITA12L','12 Gauge Buckshot','7','33','~95','50',NULL,8);
INSERT INTO `arme` VALUES (45,'ITA12S','12 Gauge Buckshot','4','21','~95','50',NULL,8);
INSERT INTO `arme` VALUES (46,'SIX12','12 Gauge Buckshot','6','30','~200','50',NULL,8);
INSERT INTO `arme` VALUES (47,'FO-12','12 Gauge Buckshot','10','40',NULL,'50',NULL,8);
INSERT INTO `arme` VALUES (48,'BOSG.12.2','12 Gauge Slug','2','59','~500','50',NULL,8);
INSERT INTO `arme` VALUES (49,'417','7.62×51mm NATO','10','90','~300','50','',2);
INSERT INTO `arme` VALUES (50,'OTs-03','7.62×54mmR','10','30','~220','36','',2);
INSERT INTO `arme` VALUES (51,'CAMRS','7.62×51mm NATO','20','140','~350','50','',2);
INSERT INTO `arme` VALUES (52,'SR-25','7.62x51mm NATO','20','40','~300','38','',2);
INSERT INTO `arme` VALUES (53,'Mk 14 EBR','7.62×51mm NATO','20','80','','50','',2);
INSERT INTO `arme` VALUES (54,'6P41','7.62×54mmR','100','301','680','50','',3);
INSERT INTO `arme` VALUES (55,'G8A1','7.62×51mm NATO','50','150','850','50','',3);
INSERT INTO `arme` VALUES (56,'M249','5.56×45mm NATO','100','301','650','50','',3);
INSERT INTO `arme` VALUES (57,'T-95 LSW','5.56×45mm NATO','80','160','650','50','',3);
INSERT INTO `arme` VALUES (58,'LMG-E','5.56×45mm NATO','150','150','720','50','',3);
INSERT INTO `arme` VALUES (59,'Skeleton Key','12 Gauge Buckshot','4','16',NULL,'50',NULL,8);
INSERT INTO `arme` VALUES (60,'P226 Mk 25','9x19mm Parabellum','15','45','~','50',NULL,6);
INSERT INTO `arme` VALUES (61,'M45 MEUSOC','.45 ACP','7','49','~360','50','',6);
INSERT INTO `arme` VALUES (62,'5.7 USG','FN 5.7×28mm','20','60','~360','50','',6);
INSERT INTO `arme` VALUES (63,'P9','9x19mm Parabellum','16','64','~360','50','',6);
INSERT INTO `arme` VALUES (64,'LFP586','.357 Magnum','6','36','~360','50','',6);
INSERT INTO `arme` VALUES (65,'GSh-18','9x19mm Parabellum','18','54','~360','50','',6);
INSERT INTO `arme` VALUES (66,'PMM','9×18mm Makarov','8','40','~420','50','',6);
INSERT INTO `arme` VALUES (67,'P12','.45 ACP','15','60','~450','50','',6);
INSERT INTO `arme` VALUES (68,'Mk1 9mm','9x19mm Parabellum','13','52','~360','50','',6);
INSERT INTO `arme` VALUES (69,'D-50','.50 Action Express','7','35','~270','50','',6);
INSERT INTO `arme` VALUES (70,'PRB92','9x19mm Parabellum','15','75','~375','50','',6);
INSERT INTO `arme` VALUES (71,'P229','.357 SIG','12','48','~375','50','',6);
INSERT INTO `arme` VALUES (72,'USP40','.40 S&W','12','48','~375','50','',6);
INSERT INTO `arme` VALUES (73,'Q-929','9×19mm Parabellum','10','50','~360','50',NULL,6);
INSERT INTO `arme` VALUES (74,'RG15','9×19mm Parabellum','15','45','~375','50','',6);
INSERT INTO `arme` VALUES (75,'SMG-11','.45 ACP','16','80','1270','50','',5);
INSERT INTO `arme` VALUES (76,'Bearing 9','9×19mm Parabellum','25','75','1100','50','',5);
INSERT INTO `arme` VALUES (77,'C75 Auto','9×19mm Parabellum','26','78','1000','50','',5);
INSERT INTO `arme` VALUES (78,'SMG-12','9×19mm Parabellum','32','160','1270','50','',5);
INSERT INTO `arme` VALUES (79,'Ballistic Shield',NULL,NULL,NULL,NULL,'30',NULL,4);
DROP TABLE IF EXISTS `accessoireArme`;
CREATE TABLE IF NOT EXISTS `accessoireArme` (
	`idAccessoire`	INTEGER,
	`idArme`	INTEGER,
	FOREIGN KEY(`idAccessoire`) REFERENCES `accessoire`(`idAccessoire`),
	FOREIGN KEY(`idArme`) REFERENCES `arme`(`idArme`),
	PRIMARY KEY(`idAccessoire`,`idArme`)
);
INSERT INTO `accessoireArme` VALUES (1,1);
INSERT INTO `accessoireArme` VALUES (2,1);
INSERT INTO `accessoireArme` VALUES (3,1);
INSERT INTO `accessoireArme` VALUES (4,1);
INSERT INTO `accessoireArme` VALUES (5,1);
INSERT INTO `accessoireArme` VALUES (6,1);
INSERT INTO `accessoireArme` VALUES (8,1);
INSERT INTO `accessoireArme` VALUES (9,1);
INSERT INTO `accessoireArme` VALUES (10,1);
INSERT INTO `accessoireArme` VALUES (12,1);
INSERT INTO `accessoireArme` VALUES (1,2);
INSERT INTO `accessoireArme` VALUES (2,2);
INSERT INTO `accessoireArme` VALUES (3,2);
INSERT INTO `accessoireArme` VALUES (4,2);
INSERT INTO `accessoireArme` VALUES (5,2);
INSERT INTO `accessoireArme` VALUES (6,2);
INSERT INTO `accessoireArme` VALUES (8,2);
INSERT INTO `accessoireArme` VALUES (9,2);
INSERT INTO `accessoireArme` VALUES (10,2);
INSERT INTO `accessoireArme` VALUES (11,2);
INSERT INTO `accessoireArme` VALUES (12,2);
INSERT INTO `accessoireArme` VALUES (1,3);
INSERT INTO `accessoireArme` VALUES (2,3);
INSERT INTO `accessoireArme` VALUES (3,3);
INSERT INTO `accessoireArme` VALUES (4,3);
INSERT INTO `accessoireArme` VALUES (5,3);
INSERT INTO `accessoireArme` VALUES (6,3);
INSERT INTO `accessoireArme` VALUES (8,3);
INSERT INTO `accessoireArme` VALUES (9,3);
INSERT INTO `accessoireArme` VALUES (10,3);
INSERT INTO `accessoireArme` VALUES (11,3);
INSERT INTO `accessoireArme` VALUES (12,3);
INSERT INTO `accessoireArme` VALUES (1,4);
INSERT INTO `accessoireArme` VALUES (2,4);
INSERT INTO `accessoireArme` VALUES (3,4);
INSERT INTO `accessoireArme` VALUES (4,4);
INSERT INTO `accessoireArme` VALUES (5,4);
INSERT INTO `accessoireArme` VALUES (6,4);
INSERT INTO `accessoireArme` VALUES (7,4);
INSERT INTO `accessoireArme` VALUES (8,4);
INSERT INTO `accessoireArme` VALUES (9,4);
INSERT INTO `accessoireArme` VALUES (10,4);
INSERT INTO `accessoireArme` VALUES (12,4);
INSERT INTO `accessoireArme` VALUES (1,5);
INSERT INTO `accessoireArme` VALUES (2,5);
INSERT INTO `accessoireArme` VALUES (3,5);
INSERT INTO `accessoireArme` VALUES (4,5);
INSERT INTO `accessoireArme` VALUES (5,5);
INSERT INTO `accessoireArme` VALUES (6,5);
INSERT INTO `accessoireArme` VALUES (8,5);
INSERT INTO `accessoireArme` VALUES (9,5);
INSERT INTO `accessoireArme` VALUES (10,5);
INSERT INTO `accessoireArme` VALUES (11,5);
INSERT INTO `accessoireArme` VALUES (12,5);
INSERT INTO `accessoireArme` VALUES (1,6);
INSERT INTO `accessoireArme` VALUES (2,6);
INSERT INTO `accessoireArme` VALUES (3,6);
INSERT INTO `accessoireArme` VALUES (4,6);
INSERT INTO `accessoireArme` VALUES (5,6);
INSERT INTO `accessoireArme` VALUES (6,6);
INSERT INTO `accessoireArme` VALUES (8,6);
INSERT INTO `accessoireArme` VALUES (9,6);
INSERT INTO `accessoireArme` VALUES (10,6);
INSERT INTO `accessoireArme` VALUES (12,6);
INSERT INTO `accessoireArme` VALUES (1,7);
INSERT INTO `accessoireArme` VALUES (2,7);
INSERT INTO `accessoireArme` VALUES (3,7);
INSERT INTO `accessoireArme` VALUES (4,7);
INSERT INTO `accessoireArme` VALUES (5,7);
INSERT INTO `accessoireArme` VALUES (6,7);
INSERT INTO `accessoireArme` VALUES (8,7);
INSERT INTO `accessoireArme` VALUES (9,7);
INSERT INTO `accessoireArme` VALUES (10,7);
INSERT INTO `accessoireArme` VALUES (11,7);
INSERT INTO `accessoireArme` VALUES (12,7);
INSERT INTO `accessoireArme` VALUES (1,8);
INSERT INTO `accessoireArme` VALUES (2,8);
INSERT INTO `accessoireArme` VALUES (3,8);
INSERT INTO `accessoireArme` VALUES (4,8);
INSERT INTO `accessoireArme` VALUES (5,8);
INSERT INTO `accessoireArme` VALUES (6,8);
INSERT INTO `accessoireArme` VALUES (8,8);
INSERT INTO `accessoireArme` VALUES (12,8);
INSERT INTO `accessoireArme` VALUES (1,9);
INSERT INTO `accessoireArme` VALUES (2,9);
INSERT INTO `accessoireArme` VALUES (3,9);
INSERT INTO `accessoireArme` VALUES (4,9);
INSERT INTO `accessoireArme` VALUES (5,9);
INSERT INTO `accessoireArme` VALUES (6,9);
INSERT INTO `accessoireArme` VALUES (8,9);
INSERT INTO `accessoireArme` VALUES (9,9);
INSERT INTO `accessoireArme` VALUES (10,9);
INSERT INTO `accessoireArme` VALUES (11,9);
INSERT INTO `accessoireArme` VALUES (12,9);
INSERT INTO `accessoireArme` VALUES (1,10);
INSERT INTO `accessoireArme` VALUES (2,10);
INSERT INTO `accessoireArme` VALUES (3,10);
INSERT INTO `accessoireArme` VALUES (5,10);
INSERT INTO `accessoireArme` VALUES (6,10);
INSERT INTO `accessoireArme` VALUES (7,10);
INSERT INTO `accessoireArme` VALUES (8,10);
INSERT INTO `accessoireArme` VALUES (9,10);
INSERT INTO `accessoireArme` VALUES (10,10);
INSERT INTO `accessoireArme` VALUES (12,10);
INSERT INTO `accessoireArme` VALUES (1,11);
INSERT INTO `accessoireArme` VALUES (2,11);
INSERT INTO `accessoireArme` VALUES (3,11);
INSERT INTO `accessoireArme` VALUES (4,11);
INSERT INTO `accessoireArme` VALUES (5,11);
INSERT INTO `accessoireArme` VALUES (6,11);
INSERT INTO `accessoireArme` VALUES (7,11);
INSERT INTO `accessoireArme` VALUES (8,11);
INSERT INTO `accessoireArme` VALUES (9,11);
INSERT INTO `accessoireArme` VALUES (12,11);
INSERT INTO `accessoireArme` VALUES (1,12);
INSERT INTO `accessoireArme` VALUES (2,12);
INSERT INTO `accessoireArme` VALUES (3,12);
INSERT INTO `accessoireArme` VALUES (4,12);
INSERT INTO `accessoireArme` VALUES (5,12);
INSERT INTO `accessoireArme` VALUES (6,12);
INSERT INTO `accessoireArme` VALUES (7,12);
INSERT INTO `accessoireArme` VALUES (8,12);
INSERT INTO `accessoireArme` VALUES (9,12);
INSERT INTO `accessoireArme` VALUES (10,12);
INSERT INTO `accessoireArme` VALUES (11,12);
INSERT INTO `accessoireArme` VALUES (12,12);
INSERT INTO `accessoireArme` VALUES (1,13);
INSERT INTO `accessoireArme` VALUES (2,13);
INSERT INTO `accessoireArme` VALUES (3,13);
INSERT INTO `accessoireArme` VALUES (4,13);
INSERT INTO `accessoireArme` VALUES (5,13);
INSERT INTO `accessoireArme` VALUES (6,13);
INSERT INTO `accessoireArme` VALUES (7,13);
INSERT INTO `accessoireArme` VALUES (8,13);
INSERT INTO `accessoireArme` VALUES (9,13);
INSERT INTO `accessoireArme` VALUES (10,13);
INSERT INTO `accessoireArme` VALUES (11,13);
INSERT INTO `accessoireArme` VALUES (12,13);
INSERT INTO `accessoireArme` VALUES (1,14);
INSERT INTO `accessoireArme` VALUES (2,14);
INSERT INTO `accessoireArme` VALUES (3,14);
INSERT INTO `accessoireArme` VALUES (4,14);
INSERT INTO `accessoireArme` VALUES (5,14);
INSERT INTO `accessoireArme` VALUES (6,14);
INSERT INTO `accessoireArme` VALUES (8,14);
INSERT INTO `accessoireArme` VALUES (9,14);
INSERT INTO `accessoireArme` VALUES (10,14);
INSERT INTO `accessoireArme` VALUES (11,14);
INSERT INTO `accessoireArme` VALUES (12,14);
INSERT INTO `accessoireArme` VALUES (1,15);
INSERT INTO `accessoireArme` VALUES (2,15);
INSERT INTO `accessoireArme` VALUES (3,15);
INSERT INTO `accessoireArme` VALUES (4,15);
INSERT INTO `accessoireArme` VALUES (5,15);
INSERT INTO `accessoireArme` VALUES (6,15);
INSERT INTO `accessoireArme` VALUES (8,15);
INSERT INTO `accessoireArme` VALUES (9,15);
INSERT INTO `accessoireArme` VALUES (10,15);
INSERT INTO `accessoireArme` VALUES (11,15);
INSERT INTO `accessoireArme` VALUES (12,15);
INSERT INTO `accessoireArme` VALUES (1,16);
INSERT INTO `accessoireArme` VALUES (2,16);
INSERT INTO `accessoireArme` VALUES (3,16);
INSERT INTO `accessoireArme` VALUES (4,16);
INSERT INTO `accessoireArme` VALUES (5,16);
INSERT INTO `accessoireArme` VALUES (6,16);
INSERT INTO `accessoireArme` VALUES (8,16);
INSERT INTO `accessoireArme` VALUES (9,16);
INSERT INTO `accessoireArme` VALUES (10,16);
INSERT INTO `accessoireArme` VALUES (11,16);
INSERT INTO `accessoireArme` VALUES (12,16);
INSERT INTO `accessoireArme` VALUES (1,17);
INSERT INTO `accessoireArme` VALUES (2,17);
INSERT INTO `accessoireArme` VALUES (3,17);
INSERT INTO `accessoireArme` VALUES (4,17);
INSERT INTO `accessoireArme` VALUES (5,17);
INSERT INTO `accessoireArme` VALUES (6,17);
INSERT INTO `accessoireArme` VALUES (8,17);
INSERT INTO `accessoireArme` VALUES (9,17);
INSERT INTO `accessoireArme` VALUES (10,17);
INSERT INTO `accessoireArme` VALUES (11,17);
INSERT INTO `accessoireArme` VALUES (12,17);
INSERT INTO `accessoireArme` VALUES (1,18);
INSERT INTO `accessoireArme` VALUES (2,18);
INSERT INTO `accessoireArme` VALUES (3,18);
INSERT INTO `accessoireArme` VALUES (4,18);
INSERT INTO `accessoireArme` VALUES (5,18);
INSERT INTO `accessoireArme` VALUES (6,18);
INSERT INTO `accessoireArme` VALUES (8,18);
INSERT INTO `accessoireArme` VALUES (9,18);
INSERT INTO `accessoireArme` VALUES (10,18);
INSERT INTO `accessoireArme` VALUES (12,18);
INSERT INTO `accessoireArme` VALUES (1,19);
INSERT INTO `accessoireArme` VALUES (3,19);
INSERT INTO `accessoireArme` VALUES (5,19);
INSERT INTO `accessoireArme` VALUES (6,19);
INSERT INTO `accessoireArme` VALUES (9,19);
INSERT INTO `accessoireArme` VALUES (12,19);
INSERT INTO `accessoireArme` VALUES (1,20);
INSERT INTO `accessoireArme` VALUES (2,20);
INSERT INTO `accessoireArme` VALUES (3,20);
INSERT INTO `accessoireArme` VALUES (5,20);
INSERT INTO `accessoireArme` VALUES (6,20);
INSERT INTO `accessoireArme` VALUES (7,20);
INSERT INTO `accessoireArme` VALUES (8,20);
INSERT INTO `accessoireArme` VALUES (12,20);
INSERT INTO `accessoireArme` VALUES (1,21);
INSERT INTO `accessoireArme` VALUES (2,21);
INSERT INTO `accessoireArme` VALUES (3,21);
INSERT INTO `accessoireArme` VALUES (5,21);
INSERT INTO `accessoireArme` VALUES (6,21);
INSERT INTO `accessoireArme` VALUES (7,21);
INSERT INTO `accessoireArme` VALUES (8,21);
INSERT INTO `accessoireArme` VALUES (9,21);
INSERT INTO `accessoireArme` VALUES (10,21);
INSERT INTO `accessoireArme` VALUES (11,21);
INSERT INTO `accessoireArme` VALUES (12,21);
INSERT INTO `accessoireArme` VALUES (1,22);
INSERT INTO `accessoireArme` VALUES (2,22);
INSERT INTO `accessoireArme` VALUES (3,22);
INSERT INTO `accessoireArme` VALUES (4,22);
INSERT INTO `accessoireArme` VALUES (5,22);
INSERT INTO `accessoireArme` VALUES (6,22);
INSERT INTO `accessoireArme` VALUES (9,22);
INSERT INTO `accessoireArme` VALUES (10,22);
INSERT INTO `accessoireArme` VALUES (12,22);
INSERT INTO `accessoireArme` VALUES (1,23);
INSERT INTO `accessoireArme` VALUES (2,23);
INSERT INTO `accessoireArme` VALUES (3,23);
INSERT INTO `accessoireArme` VALUES (4,23);
INSERT INTO `accessoireArme` VALUES (5,23);
INSERT INTO `accessoireArme` VALUES (6,23);
INSERT INTO `accessoireArme` VALUES (7,23);
INSERT INTO `accessoireArme` VALUES (9,23);
INSERT INTO `accessoireArme` VALUES (12,23);
INSERT INTO `accessoireArme` VALUES (1,24);
INSERT INTO `accessoireArme` VALUES (2,24);
INSERT INTO `accessoireArme` VALUES (3,24);
INSERT INTO `accessoireArme` VALUES (5,24);
INSERT INTO `accessoireArme` VALUES (6,24);
INSERT INTO `accessoireArme` VALUES (8,24);
INSERT INTO `accessoireArme` VALUES (9,24);
INSERT INTO `accessoireArme` VALUES (10,24);
INSERT INTO `accessoireArme` VALUES (11,24);
INSERT INTO `accessoireArme` VALUES (12,24);
INSERT INTO `accessoireArme` VALUES (1,25);
INSERT INTO `accessoireArme` VALUES (2,25);
INSERT INTO `accessoireArme` VALUES (3,25);
INSERT INTO `accessoireArme` VALUES (5,25);
INSERT INTO `accessoireArme` VALUES (6,25);
INSERT INTO `accessoireArme` VALUES (8,25);
INSERT INTO `accessoireArme` VALUES (9,25);
INSERT INTO `accessoireArme` VALUES (12,25);
INSERT INTO `accessoireArme` VALUES (1,26);
INSERT INTO `accessoireArme` VALUES (3,26);
INSERT INTO `accessoireArme` VALUES (5,26);
INSERT INTO `accessoireArme` VALUES (7,26);
INSERT INTO `accessoireArme` VALUES (11,26);
INSERT INTO `accessoireArme` VALUES (12,26);
INSERT INTO `accessoireArme` VALUES (1,27);
INSERT INTO `accessoireArme` VALUES (2,27);
INSERT INTO `accessoireArme` VALUES (3,27);
INSERT INTO `accessoireArme` VALUES (5,27);
INSERT INTO `accessoireArme` VALUES (6,27);
INSERT INTO `accessoireArme` VALUES (8,27);
INSERT INTO `accessoireArme` VALUES (9,27);
INSERT INTO `accessoireArme` VALUES (10,27);
INSERT INTO `accessoireArme` VALUES (11,27);
INSERT INTO `accessoireArme` VALUES (12,27);
INSERT INTO `accessoireArme` VALUES (1,28);
INSERT INTO `accessoireArme` VALUES (3,28);
INSERT INTO `accessoireArme` VALUES (5,28);
INSERT INTO `accessoireArme` VALUES (6,28);
INSERT INTO `accessoireArme` VALUES (7,28);
INSERT INTO `accessoireArme` VALUES (9,28);
INSERT INTO `accessoireArme` VALUES (12,28);
INSERT INTO `accessoireArme` VALUES (1,29);
INSERT INTO `accessoireArme` VALUES (2,29);
INSERT INTO `accessoireArme` VALUES (3,29);
INSERT INTO `accessoireArme` VALUES (4,29);
INSERT INTO `accessoireArme` VALUES (10,29);
INSERT INTO `accessoireArme` VALUES (11,29);
INSERT INTO `accessoireArme` VALUES (12,29);
INSERT INTO `accessoireArme` VALUES (1,30);
INSERT INTO `accessoireArme` VALUES (2,30);
INSERT INTO `accessoireArme` VALUES (3,30);
INSERT INTO `accessoireArme` VALUES (4,30);
INSERT INTO `accessoireArme` VALUES (5,30);
INSERT INTO `accessoireArme` VALUES (6,30);
INSERT INTO `accessoireArme` VALUES (8,30);
INSERT INTO `accessoireArme` VALUES (9,30);
INSERT INTO `accessoireArme` VALUES (10,30);
INSERT INTO `accessoireArme` VALUES (11,30);
INSERT INTO `accessoireArme` VALUES (12,30);
INSERT INTO `accessoireArme` VALUES (1,31);
INSERT INTO `accessoireArme` VALUES (2,31);
INSERT INTO `accessoireArme` VALUES (3,31);
INSERT INTO `accessoireArme` VALUES (5,31);
INSERT INTO `accessoireArme` VALUES (6,31);
INSERT INTO `accessoireArme` VALUES (8,31);
INSERT INTO `accessoireArme` VALUES (9,31);
INSERT INTO `accessoireArme` VALUES (10,31);
INSERT INTO `accessoireArme` VALUES (12,31);
INSERT INTO `accessoireArme` VALUES (1,32);
INSERT INTO `accessoireArme` VALUES (2,32);
INSERT INTO `accessoireArme` VALUES (3,32);
INSERT INTO `accessoireArme` VALUES (5,32);
INSERT INTO `accessoireArme` VALUES (6,32);
INSERT INTO `accessoireArme` VALUES (8,32);
INSERT INTO `accessoireArme` VALUES (9,32);
INSERT INTO `accessoireArme` VALUES (12,32);
INSERT INTO `accessoireArme` VALUES (1,33);
INSERT INTO `accessoireArme` VALUES (2,33);
INSERT INTO `accessoireArme` VALUES (3,33);
INSERT INTO `accessoireArme` VALUES (5,33);
INSERT INTO `accessoireArme` VALUES (6,33);
INSERT INTO `accessoireArme` VALUES (8,33);
INSERT INTO `accessoireArme` VALUES (9,33);
INSERT INTO `accessoireArme` VALUES (10,33);
INSERT INTO `accessoireArme` VALUES (11,33);
INSERT INTO `accessoireArme` VALUES (12,33);
INSERT INTO `accessoireArme` VALUES (1,34);
INSERT INTO `accessoireArme` VALUES (2,34);
INSERT INTO `accessoireArme` VALUES (3,34);
INSERT INTO `accessoireArme` VALUES (5,34);
INSERT INTO `accessoireArme` VALUES (6,34);
INSERT INTO `accessoireArme` VALUES (8,34);
INSERT INTO `accessoireArme` VALUES (9,34);
INSERT INTO `accessoireArme` VALUES (10,34);
INSERT INTO `accessoireArme` VALUES (11,34);
INSERT INTO `accessoireArme` VALUES (12,34);
INSERT INTO `accessoireArme` VALUES (1,35);
INSERT INTO `accessoireArme` VALUES (2,35);
INSERT INTO `accessoireArme` VALUES (3,35);
INSERT INTO `accessoireArme` VALUES (12,35);
INSERT INTO `accessoireArme` VALUES (1,36);
INSERT INTO `accessoireArme` VALUES (2,36);
INSERT INTO `accessoireArme` VALUES (3,36);
INSERT INTO `accessoireArme` VALUES (12,36);
INSERT INTO `accessoireArme` VALUES (1,37);
INSERT INTO `accessoireArme` VALUES (2,37);
INSERT INTO `accessoireArme` VALUES (3,37);
INSERT INTO `accessoireArme` VALUES (10,37);
INSERT INTO `accessoireArme` VALUES (12,37);
INSERT INTO `accessoireArme` VALUES (1,38);
INSERT INTO `accessoireArme` VALUES (2,38);
INSERT INTO `accessoireArme` VALUES (3,38);
INSERT INTO `accessoireArme` VALUES (5,38);
INSERT INTO `accessoireArme` VALUES (10,38);
INSERT INTO `accessoireArme` VALUES (11,38);
INSERT INTO `accessoireArme` VALUES (12,38);
INSERT INTO `accessoireArme` VALUES (1,39);
INSERT INTO `accessoireArme` VALUES (2,39);
INSERT INTO `accessoireArme` VALUES (3,39);
INSERT INTO `accessoireArme` VALUES (12,39);
INSERT INTO `accessoireArme` VALUES (1,40);
INSERT INTO `accessoireArme` VALUES (2,40);
INSERT INTO `accessoireArme` VALUES (3,40);
INSERT INTO `accessoireArme` VALUES (12,40);
INSERT INTO `accessoireArme` VALUES (1,41);
INSERT INTO `accessoireArme` VALUES (2,41);
INSERT INTO `accessoireArme` VALUES (3,41);
INSERT INTO `accessoireArme` VALUES (12,41);
INSERT INTO `accessoireArme` VALUES (1,42);
INSERT INTO `accessoireArme` VALUES (2,42);
INSERT INTO `accessoireArme` VALUES (3,42);
INSERT INTO `accessoireArme` VALUES (12,42);
INSERT INTO `accessoireArme` VALUES (1,43);
INSERT INTO `accessoireArme` VALUES (2,43);
INSERT INTO `accessoireArme` VALUES (3,43);
INSERT INTO `accessoireArme` VALUES (12,43);
INSERT INTO `accessoireArme` VALUES (1,44);
INSERT INTO `accessoireArme` VALUES (2,44);
INSERT INTO `accessoireArme` VALUES (3,44);
INSERT INTO `accessoireArme` VALUES (12,44);
INSERT INTO `accessoireArme` VALUES (1,45);
INSERT INTO `accessoireArme` VALUES (2,45);
INSERT INTO `accessoireArme` VALUES (3,45);
INSERT INTO `accessoireArme` VALUES (12,45);
INSERT INTO `accessoireArme` VALUES (1,46);
INSERT INTO `accessoireArme` VALUES (2,46);
INSERT INTO `accessoireArme` VALUES (3,46);
INSERT INTO `accessoireArme` VALUES (12,46);
INSERT INTO `accessoireArme` VALUES (1,47);
INSERT INTO `accessoireArme` VALUES (2,47);
INSERT INTO `accessoireArme` VALUES (3,47);
INSERT INTO `accessoireArme` VALUES (5,47);
INSERT INTO `accessoireArme` VALUES (7,47);
INSERT INTO `accessoireArme` VALUES (10,47);
INSERT INTO `accessoireArme` VALUES (11,47);
INSERT INTO `accessoireArme` VALUES (12,47);
INSERT INTO `accessoireArme` VALUES (1,48);
INSERT INTO `accessoireArme` VALUES (2,48);
INSERT INTO `accessoireArme` VALUES (3,48);
INSERT INTO `accessoireArme` VALUES (10,48);
INSERT INTO `accessoireArme` VALUES (11,48);
INSERT INTO `accessoireArme` VALUES (12,48);
INSERT INTO `accessoireArme` VALUES (1,49);
INSERT INTO `accessoireArme` VALUES (2,49);
INSERT INTO `accessoireArme` VALUES (4,49);
INSERT INTO `accessoireArme` VALUES (5,49);
INSERT INTO `accessoireArme` VALUES (6,49);
INSERT INTO `accessoireArme` VALUES (8,49);
INSERT INTO `accessoireArme` VALUES (9,49);
INSERT INTO `accessoireArme` VALUES (10,49);
INSERT INTO `accessoireArme` VALUES (12,49);
INSERT INTO `accessoireArme` VALUES (1,50);
INSERT INTO `accessoireArme` VALUES (2,50);
INSERT INTO `accessoireArme` VALUES (3,50);
INSERT INTO `accessoireArme` VALUES (5,50);
INSERT INTO `accessoireArme` VALUES (6,50);
INSERT INTO `accessoireArme` VALUES (9,50);
INSERT INTO `accessoireArme` VALUES (1,51);
INSERT INTO `accessoireArme` VALUES (2,51);
INSERT INTO `accessoireArme` VALUES (3,51);
INSERT INTO `accessoireArme` VALUES (4,51);
INSERT INTO `accessoireArme` VALUES (5,51);
INSERT INTO `accessoireArme` VALUES (6,51);
INSERT INTO `accessoireArme` VALUES (8,51);
INSERT INTO `accessoireArme` VALUES (9,51);
INSERT INTO `accessoireArme` VALUES (12,51);
INSERT INTO `accessoireArme` VALUES (1,52);
INSERT INTO `accessoireArme` VALUES (2,52);
INSERT INTO `accessoireArme` VALUES (3,52);
INSERT INTO `accessoireArme` VALUES (4,52);
INSERT INTO `accessoireArme` VALUES (5,52);
INSERT INTO `accessoireArme` VALUES (6,52);
INSERT INTO `accessoireArme` VALUES (8,52);
INSERT INTO `accessoireArme` VALUES (9,52);
INSERT INTO `accessoireArme` VALUES (10,52);
INSERT INTO `accessoireArme` VALUES (12,52);
INSERT INTO `accessoireArme` VALUES (1,53);
INSERT INTO `accessoireArme` VALUES (2,53);
INSERT INTO `accessoireArme` VALUES (3,53);
INSERT INTO `accessoireArme` VALUES (4,53);
INSERT INTO `accessoireArme` VALUES (5,53);
INSERT INTO `accessoireArme` VALUES (6,53);
INSERT INTO `accessoireArme` VALUES (8,53);
INSERT INTO `accessoireArme` VALUES (9,53);
INSERT INTO `accessoireArme` VALUES (10,53);
INSERT INTO `accessoireArme` VALUES (11,53);
INSERT INTO `accessoireArme` VALUES (12,53);
INSERT INTO `accessoireArme` VALUES (1,54);
INSERT INTO `accessoireArme` VALUES (2,54);
INSERT INTO `accessoireArme` VALUES (3,54);
INSERT INTO `accessoireArme` VALUES (4,54);
INSERT INTO `accessoireArme` VALUES (5,54);
INSERT INTO `accessoireArme` VALUES (6,54);
INSERT INTO `accessoireArme` VALUES (10,54);
INSERT INTO `accessoireArme` VALUES (12,54);
INSERT INTO `accessoireArme` VALUES (1,55);
INSERT INTO `accessoireArme` VALUES (2,55);
INSERT INTO `accessoireArme` VALUES (3,55);
INSERT INTO `accessoireArme` VALUES (4,55);
INSERT INTO `accessoireArme` VALUES (5,55);
INSERT INTO `accessoireArme` VALUES (6,55);
INSERT INTO `accessoireArme` VALUES (8,55);
INSERT INTO `accessoireArme` VALUES (10,55);
INSERT INTO `accessoireArme` VALUES (1,56);
INSERT INTO `accessoireArme` VALUES (2,56);
INSERT INTO `accessoireArme` VALUES (3,56);
INSERT INTO `accessoireArme` VALUES (4,56);
INSERT INTO `accessoireArme` VALUES (6,56);
INSERT INTO `accessoireArme` VALUES (8,56);
INSERT INTO `accessoireArme` VALUES (10,56);
INSERT INTO `accessoireArme` VALUES (12,56);
INSERT INTO `accessoireArme` VALUES (1,57);
INSERT INTO `accessoireArme` VALUES (2,57);
INSERT INTO `accessoireArme` VALUES (3,57);
INSERT INTO `accessoireArme` VALUES (4,57);
INSERT INTO `accessoireArme` VALUES (5,57);
INSERT INTO `accessoireArme` VALUES (6,57);
INSERT INTO `accessoireArme` VALUES (8,57);
INSERT INTO `accessoireArme` VALUES (9,57);
INSERT INTO `accessoireArme` VALUES (10,57);
INSERT INTO `accessoireArme` VALUES (11,57);
INSERT INTO `accessoireArme` VALUES (12,57);
INSERT INTO `accessoireArme` VALUES (1,58);
INSERT INTO `accessoireArme` VALUES (2,58);
INSERT INTO `accessoireArme` VALUES (3,58);
INSERT INTO `accessoireArme` VALUES (4,58);
INSERT INTO `accessoireArme` VALUES (5,58);
INSERT INTO `accessoireArme` VALUES (6,58);
INSERT INTO `accessoireArme` VALUES (8,58);
INSERT INTO `accessoireArme` VALUES (9,58);
INSERT INTO `accessoireArme` VALUES (10,58);
INSERT INTO `accessoireArme` VALUES (12,58);
INSERT INTO `accessoireArme` VALUES (5,60);
INSERT INTO `accessoireArme` VALUES (9,60);
INSERT INTO `accessoireArme` VALUES (12,60);
INSERT INTO `accessoireArme` VALUES (5,61);
INSERT INTO `accessoireArme` VALUES (9,61);
INSERT INTO `accessoireArme` VALUES (12,61);
INSERT INTO `accessoireArme` VALUES (5,62);
INSERT INTO `accessoireArme` VALUES (9,62);
INSERT INTO `accessoireArme` VALUES (12,62);
INSERT INTO `accessoireArme` VALUES (5,63);
INSERT INTO `accessoireArme` VALUES (9,63);
INSERT INTO `accessoireArme` VALUES (12,63);
INSERT INTO `accessoireArme` VALUES (12,64);
INSERT INTO `accessoireArme` VALUES (5,65);
INSERT INTO `accessoireArme` VALUES (9,65);
INSERT INTO `accessoireArme` VALUES (5,66);
INSERT INTO `accessoireArme` VALUES (9,66);
INSERT INTO `accessoireArme` VALUES (12,66);
INSERT INTO `accessoireArme` VALUES (5,67);
INSERT INTO `accessoireArme` VALUES (9,67);
INSERT INTO `accessoireArme` VALUES (12,67);
INSERT INTO `accessoireArme` VALUES (5,68);
INSERT INTO `accessoireArme` VALUES (9,68);
INSERT INTO `accessoireArme` VALUES (12,68);
INSERT INTO `accessoireArme` VALUES (12,69);
INSERT INTO `accessoireArme` VALUES (5,70);
INSERT INTO `accessoireArme` VALUES (9,70);
INSERT INTO `accessoireArme` VALUES (12,70);
INSERT INTO `accessoireArme` VALUES (5,71);
INSERT INTO `accessoireArme` VALUES (9,71);
INSERT INTO `accessoireArme` VALUES (12,71);
INSERT INTO `accessoireArme` VALUES (5,72);
INSERT INTO `accessoireArme` VALUES (9,72);
INSERT INTO `accessoireArme` VALUES (12,72);
INSERT INTO `accessoireArme` VALUES (5,73);
INSERT INTO `accessoireArme` VALUES (9,73);
INSERT INTO `accessoireArme` VALUES (12,73);
INSERT INTO `accessoireArme` VALUES (5,74);
INSERT INTO `accessoireArme` VALUES (9,74);
INSERT INTO `accessoireArme` VALUES (12,74);
INSERT INTO `accessoireArme` VALUES (1,75);
INSERT INTO `accessoireArme` VALUES (2,75);
INSERT INTO `accessoireArme` VALUES (3,75);
INSERT INTO `accessoireArme` VALUES (5,75);
INSERT INTO `accessoireArme` VALUES (6,75);
INSERT INTO `accessoireArme` VALUES (7,75);
INSERT INTO `accessoireArme` VALUES (8,75);
INSERT INTO `accessoireArme` VALUES (10,75);
INSERT INTO `accessoireArme` VALUES (12,75);
INSERT INTO `accessoireArme` VALUES (1,76);
INSERT INTO `accessoireArme` VALUES (2,76);
INSERT INTO `accessoireArme` VALUES (3,76);
INSERT INTO `accessoireArme` VALUES (5,76);
INSERT INTO `accessoireArme` VALUES (6,76);
INSERT INTO `accessoireArme` VALUES (8,76);
INSERT INTO `accessoireArme` VALUES (12,76);
INSERT INTO `accessoireArme` VALUES (5,77);
INSERT INTO `accessoireArme` VALUES (1,78);
INSERT INTO `accessoireArme` VALUES (2,78);
INSERT INTO `accessoireArme` VALUES (3,78);
INSERT INTO `accessoireArme` VALUES (10,78);
INSERT INTO `accessoireArme` VALUES (11,78);
INSERT INTO `accessoireArme` VALUES (12,78);
DROP TABLE IF EXISTS `accessoire`;
CREATE TABLE IF NOT EXISTS `accessoire` (
	`idAccessoire`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nomAccessoire`	TEXT,
	`cheminImageAccessoire`	TEXT,
	`idTypeAccessoire`	INTEGER,
	FOREIGN KEY(`idTypeAccessoire`) REFERENCES `typeAccessoire`(`idTypeAccessoire`)
);
INSERT INTO `accessoire` VALUES (1,'Point rouge',NULL,2);
INSERT INTO `accessoire` VALUES (2,'Holographique',NULL,2);
INSERT INTO `accessoire` VALUES (3,'Réflex',NULL,2);
INSERT INTO `accessoire` VALUES (4,'ACOG',NULL,2);
INSERT INTO `accessoire` VALUES (5,'Silencieux',NULL,1);
INSERT INTO `accessoire` VALUES (6,'Cache-flamme',NULL,1);
INSERT INTO `accessoire` VALUES (7,'Canon allongé',NULL,1);
INSERT INTO `accessoire` VALUES (8,'Compensateur',NULL,1);
INSERT INTO `accessoire` VALUES (9,'Frein de bouche',NULL,1);
INSERT INTO `accessoire` VALUES (10,'Verticale',NULL,3);
INSERT INTO `accessoire` VALUES (11,'Inclinée',NULL,3);
INSERT INTO `accessoire` VALUES (12,'Laser',NULL,4);
COMMIT;
