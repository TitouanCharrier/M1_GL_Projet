-- Création de la table Resource
CREATE TABLE IF NOT EXISTS Resource (
    id TEXT PRIMARY KEY,
    title TEXT NOT NULL,
    description TEXT,
    creationDate DATE,
    price REAL,
    category TEXT,
    type TEXT CHECK(type IN ('bien', 'service'))
);

-- Insertion de 30 entrées
INSERT INTO Resource (id, title, description, creationDate, price, category, type) VALUES
('1', 'Laptop HP', 'Ordinateur portable HP performant', '2025-01-12', 899.99, 'Informatique', 'bien'),
('2', 'Formation Java', 'Cours complet sur Java pour débutants', '2025-02-05', 199.99, 'Education', 'service'),
('3', 'Smartphone Samsung', 'Smartphone Samsung Galaxy dernier modèle', '2025-03-20', 699.50, 'Téléphonie', 'bien'),
('4', 'Consulting SEO', 'Optimisation SEO pour votre site web', '2025-01-25', 350.00, 'Marketing', 'service'),
('5', 'Table IKEA', 'Table en bois massif', '2025-02-15', 120.00, 'Meubles', 'bien'),
('6', 'Cours Yoga', 'Séance de yoga en ligne', '2025-03-10', 25.00, 'Bien-être', 'service'),
('7', 'Chaise Design', 'Chaise design confortable', '2025-04-01', 85.00, 'Meubles', 'bien'),
('8', 'Service de Traduction', 'Traduction français-anglais', '2025-01-18', 50.00, 'Services', 'service'),
('9', 'Appareil Photo Canon', 'Appareil photo reflex Canon EOS', '2025-02-22', 1200.00, 'Photo', 'bien'),
('10', 'Cours de Piano', 'Leçons de piano pour débutants', '2025-03-05', 40.00, 'Education', 'service'),
('11', 'Montre Apple', 'Apple Watch série 9', '2025-02-12', 399.00, 'Technologie', 'bien'),
('12', 'Nettoyage Maison', 'Service de nettoyage complet', '2025-03-15', 80.00, 'Services', 'service'),
('13', 'Vélo de Route', 'Vélo léger pour la route', '2025-04-03', 650.00, 'Sport', 'bien'),
('14', 'Coaching Sportif', 'Séance de coaching personnalisé', '2025-01-28', 60.00, 'Bien-être', 'service'),
('15', 'Télévision LG', 'TV LG 55 pouces 4K', '2025-02-10', 750.00, 'Electroménager', 'bien'),
('16', 'Rédaction Web', 'Rédaction d’articles SEO', '2025-03-12', 35.00, 'Marketing', 'service'),
('17', 'Casque Audio Bose', 'Casque audio Bose sans fil', '2025-02-20', 220.00, 'Audio', 'bien'),
('18', 'Cours de Cuisine', 'Atelier cuisine italienne', '2025-03-22', 45.00, 'Education', 'service'),
('19', 'Sac à Dos', 'Sac à dos étanche pour randonnée', '2025-04-05', 60.00, 'Accessoires', 'bien'),
('20', 'Jardinage', 'Service d’entretien jardin', '2025-01-30', 90.00, 'Services', 'service'),
('21', 'Imprimante Epson', 'Imprimante couleur multifonction', '2025-02-18', 150.00, 'Informatique', 'bien'),
('22', 'Cours de Photographie', 'Atelier photo pour débutants', '2025-03-08', 50.00, 'Education', 'service'),
('23', 'Micro-onde Samsung', 'Micro-onde compact Samsung', '2025-02-25', 120.00, 'Electroménager', 'bien'),
('24', 'Service de Babysitting', 'Garde d’enfants à domicile', '2025-03-18', 15.00, 'Services', 'service'),
('25', 'Guitare Fender', 'Guitare électrique Fender', '2025-04-02', 800.00, 'Musique', 'bien'),
('26', 'Cours de Natation', 'Leçons de natation pour enfants', '2025-01-20', 30.00, 'Sport', 'service'),
('27', 'Chaussures Nike', 'Chaussures de sport Nike', '2025-02-28', 120.00, 'Sport', 'bien'),
('28', 'Réparation Ordinateur', 'Dépannage PC à domicile', '2025-03-25', 70.00, 'Informatique', 'service'),
('29', 'Canapé 3 places', 'Canapé en cuir confortable', '2025-04-06', 950.00, 'Meubles', 'bien'),
('30', 'Cours de Dessin', 'Atelier de dessin pour adultes', '2025-01-22', 40.00, 'Education', 'service');
