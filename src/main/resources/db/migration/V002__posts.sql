CREATE TABLE posts (
    id UUID PRIMARY KEY default gen_random_uuid(),

    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,

    user_id UUID NOT NULL,

    visible BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)
