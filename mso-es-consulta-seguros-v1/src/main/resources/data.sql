INSERT INTO SEGURO (ID_SEGURO, NOMBRE, DESCRIPCION, BENEFICIOS, COSTO_ANUAL,
                    EDAD_MINIMA, EDAD_MAXIMA, REQUIERE_GENERO_MUJER)
VALUES
(1, 'VIDA',
 'Protección económica para tu familia en caso de fallecimiento natural o accidental.',
 'Beneficio económico para tu familia (mayor en caso de fallecimiento accidental). Servicio funerario sin costo adicional.',
 700, 18, 75, FALSE),

(2, 'INFARTO',
 'Protección económica de $50,000 por la primera ocurrencia de infarto al miocardio.',
 'Envío de ambulancia. Consultas médicas telefónicas ilimitadas. No se requiere presentar exámenes médicos.',
 300, 15, 64, FALSE),

(3, 'MUJER',
 'Protección económica de $50,000 por el primer diagnóstico de cáncer de mama o cervicouterino.',
 '20 consultas psicológicas a domicilio (al diagnosticarse el cáncer). Consultas psicológicas telefónicas ilimitadas. No se requiere presentar exámenes médicos.',
 300, 15, 64, TRUE);
