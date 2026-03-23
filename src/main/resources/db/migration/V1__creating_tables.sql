CREATE TABLE board (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   name VARCHAR(255) NOT NULL
);


CREATE TABLE columns (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     name VARCHAR(255) NOT NULL,
     position INTEGER NOT NULL,
     board_id UUID NOT NULL,
     CONSTRAINT fk_board
         FOREIGN KEY (board_id)
             REFERENCES board(id)
             ON DELETE CASCADE

);

CREATE TABLE task (
      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
      name VARCHAR(255) NOT NULL,
      position INTEGER NOT NULL,
      created_at TIMESTAMP WITH TIME ZONE NOT NULL,
      due_date TIMESTAMP,
      completed BOOLEAN DEFAULT FALSE,
      tags TEXT[],
      column_id UUID NOT NULL,

      CONSTRAINT fk_column
          FOREIGN KEY (column_id)
              REFERENCES columns(id)
              ON DELETE CASCADE
);