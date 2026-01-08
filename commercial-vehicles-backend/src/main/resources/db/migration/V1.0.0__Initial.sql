-- Create Vehicle Table
CREATE TABLE vehicle (
    id BIGINT IDENTITY PRIMARY KEY, -- Auto-incrementing ID column
    model VARCHAR(255) NOT NULL,    -- Model of the vehicle
    vehicle_year INTEGER NOT NULL,  -- Renamed from 'year' to avoid reserved keyword conflict
    mileage INTEGER NOT NULL,       -- Mileage of the vehicle
    dtype VARCHAR(31) NOT NULL,     -- Discriminator column to differentiate subclasses
    load_capacity INTEGER           -- Nullable for non-Truck entities
);
-- Create Truck Table
CREATE TABLE trucks (
    id BIGINT PRIMARY KEY REFERENCES vehicles(id), -- Foreign key referencing vehicles
    load_capacity INTEGER NOT NULL                 -- Load capacity in tons
);