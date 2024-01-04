import {Control, Controller, ControllerProps, FieldPath, FieldValues} from "react-hook-form";
import {DateField} from "@mui/x-date-pickers";
import {DateFieldProps} from "@mui/x-date-pickers/DateField/DateField.types";

interface IDateFieldFormProps<TDate, TFieldValues extends FieldValues = FieldValues, TName extends FieldPath<TFieldValues> = FieldPath<TFieldValues>, TContext = any>{
  name: string
  label: string
  control: Control<TFieldValues, TContext>
  variant?: DateFieldProps<TDate>["variant"]
  rules?: ControllerProps<TFieldValues, TName>["rules"]
  dateFieldProps?: DateFieldProps<TDate>
  controllerProps?: ControllerProps<TFieldValues, TName>
}

const CDateFieldForm = <TDate,>({ control, name, label, dateFieldProps, controllerProps, rules, variant }: IDateFieldFormProps<TDate>) => (
  <Controller
    render={({ field }) => (
      <DateField
        {...field}
        {...{
          ...dateFieldProps,
          label,
          variant
        }}
      />
    )}
    {...{
      ...controllerProps,
      name,
      control,
      rules,
    }}
  />
)

export default CDateFieldForm
