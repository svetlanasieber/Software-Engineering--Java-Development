CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19,4),
 yearly_interest DECIMAL (10, 4),
  number_of_years DECIMAL (10,4))
    RETURNS DECIMAL(19,4)
    READS SQL DATA
BEGIN
    RETURN initial_sum * POW((1 + yearly_interest), number_of_years);
end
