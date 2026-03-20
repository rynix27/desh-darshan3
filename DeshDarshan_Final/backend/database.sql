-- ============================================
-- DeshDarshan - MySQL Database Setup Script
-- Run this in MySQL before starting the app
-- ============================================

-- Step 1: Create the database
CREATE DATABASE IF NOT EXISTS deshdarshan_db;
USE deshdarshan_db;

-- ============================================
-- TABLE: destinations
-- ============================================
CREATE TABLE IF NOT EXISTS destinations (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    state       VARCHAR(100) NOT NULL,
    region      VARCHAR(50),
    capital     VARCHAR(100),
    description TEXT,
    tagline     VARCHAR(255),
    best_time   VARCHAR(100),
    budget      VARCHAR(50),
    latitude    DOUBLE,
    longitude   DOUBLE,
    image_url   VARCHAR(500)
);

-- ============================================
-- TABLE: hotels
-- ============================================
CREATE TABLE IF NOT EXISTS hotels (
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(200) NOT NULL,
    category         VARCHAR(20),
    price_per_night  INT,
    rating           DOUBLE,
    review_quote     TEXT,
    destination_name VARCHAR(100),
    latitude         DOUBLE,
    longitude        DOUBLE,
    amenities        VARCHAR(500),
    featured         BOOLEAN DEFAULT FALSE,
    image_url        VARCHAR(500)
);

-- ============================================
-- TABLE: bookings
-- ============================================
CREATE TABLE IF NOT EXISTS bookings (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    guest_name      VARCHAR(150) NOT NULL,
    email           VARCHAR(150) NOT NULL,
    booking_type    VARCHAR(50),
    item_name       VARCHAR(200),
    check_in        DATE,
    check_out       DATE,
    number_of_guests INT,
    total_amount    INT,
    status          VARCHAR(20) DEFAULT 'PENDING',
    special_requests TEXT,
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- TABLE: users
-- ============================================
CREATE TABLE IF NOT EXISTS users (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name     VARCHAR(150) NOT NULL,
    email         VARCHAR(150) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    role          VARCHAR(20) DEFAULT 'USER',
    phone         VARCHAR(20),
    registered_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- TABLE: contact_messages
-- ============================================
CREATE TABLE IF NOT EXISTS contact_messages (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender_name  VARCHAR(150) NOT NULL,
    sender_email VARCHAR(150) NOT NULL,
    subject      VARCHAR(255),
    message      TEXT NOT NULL,
    status       VARCHAR(20) DEFAULT 'NEW',
    sent_at      DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- SEED DATA: destinations
-- ============================================
INSERT INTO destinations (name, state, region, capital, tagline, best_time, budget, latitude, longitude, description) VALUES
('Rajasthan',         'Rajasthan',         'north',     'Jaipur',            'The Land of Kings',               'Oct - Mar',             'Budget to Luxury', 26.9124, 75.7873, 'India''s most vivid state — vast Thar Desert sands, elaborate palaces, ancient forts, and living royal traditions.'),
('Kerala',            'Kerala',            'south',     'Thiruvananthapuram', 'God''s Own Country',               'Nov - Feb',             'Mid to Luxury',    10.8505, 76.2711, 'A long green ribbon along the southwest coast — backwater canals, spice-scented hills, and Ayurvedic healing centres.'),
('Uttar Pradesh',     'Uttar Pradesh',     'north',     'Lucknow',           'The Spiritual Heart of India',    'Oct - Mar',             'Budget',           26.8467, 80.9462, 'Home to the Taj Mahal, the ghats of Varanasi, and the Mughal splendour of Fatehpur Sikri.'),
('Himachal Pradesh',  'Himachal Pradesh',  'north',     'Shimla',            'Land of Snow and Spirits',        'Mar - Jun, Dec - Feb',  'Budget',           32.2396, 77.1887, 'Snow-capped peaks, river valleys green with apple orchards, and Tibetan Buddhist monasteries perched on cliffs.'),
('Goa',               'Goa',               'west',      'Panaji',            'Where India Meets the Sea',       'Nov - Feb',             'Budget to Mid',    15.2993, 74.1240, '105km of coastline, Portuguese-built churches, spice plantations, and a culture of easy living.'),
('Karnataka',         'Karnataka',         'south',     'Bengaluru',         'Cradle of South Indian Civilisation', 'Oct - Feb',         'Budget',           15.3173, 75.7139, 'Three UNESCO World Heritage Sites, the largest palace lit by 100,000 bulbs, and the ruins of Hampi.'),
('Tamil Nadu',        'Tamil Nadu',        'south',     'Chennai',           'Land of Dravidian Temples',       'Oct - Mar',             'Budget',           11.1271, 78.6569, 'Enormous gopuram temple towers, Carnatic classical music, Bharatanatyam dance, and 1,076km of coastline.'),
('Maharashtra',       'Maharashtra',       'west',      'Mumbai',            'Land of History and Commerce',    'Nov - Feb',             'Budget to Luxury', 19.7515, 75.7139, 'From Mumbai to the UNESCO caves of Ajanta and Ellora, to the Deccan plateau forts of Shivaji Maharaj.'),
('Gujarat',           'Gujarat',           'west',      'Gandhinagar',       'Land of Commerce and the Mahatma', 'Nov - Feb',            'Budget',           22.2587, 71.1924, 'The pure white salt desert of the Rann, the lions of Gir, and the birthplace of both Gandhi and Ambani.'),
('West Bengal',       'West Bengal',       'east',      'Kolkata',           'City of Intellectuals and Festivals', 'Oct - Mar',          'Budget',           22.9868, 87.8550, 'Nobel laureates, the most celebrated festival, the greatest poets, and the most sophisticated cuisine.');

-- ============================================
-- SEED DATA: hotels
-- ============================================
INSERT INTO hotels (name, category, price_per_night, rating, review_quote, destination_name, featured, amenities) VALUES
('Hotel Pearl Palace',        'budget',  900,   4.4, 'Excellent value, rooftop restaurant with fort views.',     'Rajasthan',     FALSE, 'WiFi,Rooftop,AC'),
('Umaid Mahal Heritage Hotel','mid',     4200,  4.6, 'Beautiful heritage property with carved stonework.',        'Rajasthan',     TRUE,  'WiFi,Pool,Spa,AC'),
('Taj Lake Palace Udaipur',   'luxury',  32000, 4.9, 'The most romantic hotel in India — a floating palace.',    'Rajasthan',     TRUE,  'WiFi,Pool,Spa,Restaurant,Butler'),
('GoNomad Backpacker Hostel', 'budget',  650,   4.2, 'Great for solo travellers — clean dorms, free breakfast.', 'Kerala',        FALSE, 'WiFi,Common Area'),
('Fragrant Nature Resort',    'mid',     5800,  4.5, 'Beautiful pool villa with backwater views.',               'Kerala',        TRUE,  'WiFi,Pool,Spa,Ayurveda'),
('Kumarakom Lake Resort',     'luxury',  28000, 4.8, 'Private pool villas on the backwaters, amazing sunrise.',  'Kerala',        TRUE,  'WiFi,Pool,Spa,Restaurant,Butler'),
('Hotel Siddhartha Varanasi', 'budget',  700,   4.1, 'Rooftop restaurant with live Ganga aarti view.',           'Uttar Pradesh', FALSE, 'WiFi,Rooftop'),
('Oberoi Amarvilas Agra',     'luxury',  38000, 4.9, 'Every single room has a direct Taj Mahal view.',           'Uttar Pradesh', TRUE,  'WiFi,Pool,Spa,Restaurant,Butler'),
('Zostel Manali',             'budget',  500,   4.3, 'Best hostel in Manali — mountain views, great community.', 'Himachal Pradesh', FALSE, 'WiFi,Common Area,Fireplace'),
('Wildflower Hall Shimla',    'luxury',  22000, 4.8, 'Former residence of Lord Kitchener — Himalayan panoramas.','Himachal Pradesh', TRUE,  'WiFi,Pool,Spa,Restaurant'),
('Taj Exotica South Goa',     'luxury',  24000, 4.8, '25 acres of private beachfront, infinity pools.',          'Goa',           TRUE,  'WiFi,Pool,Spa,Restaurant,Beach'),
('The Postcard Velha Old Goa','mid',     8500,  4.7, 'A converted Indo-Portuguese mansion — boutique.',          'Goa',           TRUE,  'WiFi,Pool,AC'),
('Evolve Back Coorg',         'mid',     9000,  4.7, 'Coffee estate bungalows — Ayurvedic spa treatments.',      'Karnataka',     TRUE,  'WiFi,Pool,Spa,Coffee Estate'),
('Taj West End Bengaluru',    'luxury',  15000, 4.7, 'A 20-acre garden in the heart of Bengaluru.',             'Karnataka',     TRUE,  'WiFi,Pool,Spa,Restaurant'),
('Taj Mahal Palace Mumbai',   'luxury',  35000, 4.9, 'One of the great hotels of the world — 120 years old.',   'Maharashtra',   TRUE,  'WiFi,Pool,Spa,Restaurant,Butler');

-- ============================================
-- SEED DATA: sample booking
-- ============================================
INSERT INTO bookings (guest_name, email, booking_type, item_name, check_in, check_out, number_of_guests, total_amount, status) VALUES
('Arjun Sharma', 'arjun@example.com', 'hotel', 'Taj Lake Palace Udaipur', '2026-10-15', '2026-10-18', 2, 96000, 'CONFIRMED');

-- ============================================
-- VIEW: booking summary (useful for reports)
-- ============================================
CREATE OR REPLACE VIEW booking_summary AS
SELECT
    b.id,
    b.guest_name,
    b.email,
    b.booking_type,
    b.item_name,
    b.check_in,
    b.check_out,
    DATEDIFF(b.check_out, b.check_in) AS nights,
    b.number_of_guests,
    b.total_amount,
    b.status,
    b.created_at
FROM bookings b;

-- ============================================
-- Verify setup
-- ============================================
SELECT 'destinations' AS table_name, COUNT(*) AS rows FROM destinations
UNION ALL
SELECT 'hotels',          COUNT(*) FROM hotels
UNION ALL
SELECT 'bookings',        COUNT(*) FROM bookings
UNION ALL
SELECT 'users',           COUNT(*) FROM users
UNION ALL
SELECT 'contact_messages',COUNT(*) FROM contact_messages;
